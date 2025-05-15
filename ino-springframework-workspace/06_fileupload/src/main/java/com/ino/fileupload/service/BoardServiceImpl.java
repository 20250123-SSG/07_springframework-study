package com.ino.fileupload.service;

import com.ino.fileupload.dao.BoardMapper;
import com.ino.fileupload.dto.AttachmentDto;
import com.ino.fileupload.dto.BoardDto;
import com.ino.fileupload.util.FileUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {
    private final SqlSessionTemplate sqlSessionTemplate;
    private final FileUtil fileUtil;

    @Override
    public int registOneFileBoard(BoardDto board, MultipartFile mpf) {
        BoardMapper boardMapper = sqlSessionTemplate.getMapper(BoardMapper.class);

        int result = boardMapper.insertBoard(board); // boardNo gen

        if(result > 0 && mpf != null && !mpf.getOriginalFilename().equals("")){

            Map<String, String> map = fileUtil.fileupload(mpf);
            AttachmentDto attachment = new AttachmentDto().builder()
                    .filePath(map.get("filePath"))
                    .originalName(map.get("orgFileName"))
                    .filesystemName(map.get("randUUID"))
                    .refBoardNo(board.getBoardNo())
                    .build();

            result = boardMapper.insertAttachment(attachment);


        }
        return result;
    }

    @Override
    public int registMultiFileBoard(BoardDto board, List<MultipartFile> mpfList) {
        BoardMapper boardMapper = sqlSessionTemplate.getMapper(BoardMapper.class);

        int result = boardMapper.insertBoard(board); // boardNo gen

        if(result > 0 && !mpfList.isEmpty()){
            // 1) file upload
            // 1-1) set upload path (/upload/board/yyyyMMdd
            String filePath = "/upload/board" + DateTimeFormatter.ofPattern("/yyyyMMdd").format(LocalDate.now());
            File filePathDir = new File("C:" +filePath);
            if(!filePathDir.exists()) { // if not exists
                filePathDir.mkdirs(); // make directory
            }
            // 1-2) change file name
            String orgFileName = mpfList.get(0).getOriginalFilename();
            String ext = orgFileName.substring(orgFileName.lastIndexOf("."));
            String randUUID = UUID.randomUUID().toString().replace("-", "");  // UUID.randomUUID() : generate rand Val(32, four hypen)


            // 1-3. upload
            try {
                mpfList.get(0).transferTo(new File(filePathDir, randUUID));
            } catch (IOException e) {
                e.printStackTrace();
            }

            // 2. tbl_attachment insert (db에 기록 - 저장경로, 원본며으 실제저장파일명, 참조게시글번호)
            AttachmentDto attachment = new AttachmentDto().builder()
                    .filePath(filePath)
                    .originalName(orgFileName)
                    .filesystemName(randUUID)
                    .refBoardNo(board.getBoardNo())
                    .build();
            result = boardMapper.insertAttachment(attachment);

        }
        return result;
    }
}
