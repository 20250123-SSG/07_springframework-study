package com.sotogito.fileupload.service;

import com.sotogito.fileupload.dao.BoardMapper;
import com.sotogito.fileupload.dto.AttachmentDto;
import com.sotogito.fileupload.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final SqlSessionTemplate sqlSession;


    /**
     * 서비스에서 처리할거임
     * 1. tbl_board insert
     * 2. 첨부파일 업로드(저장)
     * 3. tbl_attachment insert
     */
    @Override
    public int registOneFileBoard(BoardDto board, MultipartFile uploadFile) {
        BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);

        int insertResult = boardMapper.insertBoard(board);

        boolean isUploadFileValid = (insertResult > 0 && uploadFile != null && !uploadFile.getOriginalFilename().equals(""));
        if(isUploadFileValid) {
            /// 저장경로
            String filePath = "/upload/board/"+ DateTimeFormatter.ofPattern("/yyyyMMdd").format(LocalDate.now());
            File filePathDir = new File("C:"+filePath);

            if(!filePathDir.exists()) { // 저장할 경로에 폴더가 없다면
                filePathDir.mkdirs();   //폴더를 생성
            }
            /// 파일명 수정
            String originalFileName = uploadFile.getOriginalFilename(); //abc.def.jpg
            String ext = originalFileName.substring(originalFileName.lastIndexOf(".")); //.jpg
            String filesystemName = UUID.randomUUID().toString().replace("-", "") + ext;// uuid를 사용하여 절대 겹치지않은 파일명으로 설정

            /// 업로드(지정한 폴더에 파일을 저장)
            try {
                uploadFile.transferTo(new File(filePathDir, filesystemName)); //중복되지않은파일 이름으로 저장하겠다.
            } catch (IOException e) {
                e.printStackTrace();
            }

            /// db에 저장 - tbl_attachment insert (저장명, 원본명, 수정명, 참조게시글번호)
            AttachmentDto attachment = AttachmentDto.builder()
                                                    .filePath(filePath)
                                                    .originalName(originalFileName)
                                                    .filesystemName(filesystemName)
                                                    .refBoardNo(board.getBoardNo())
                                                    .build();
            insertResult = boardMapper.insertAttach(attachment);
        }

        return insertResult;
    }

    @Override
    public int registManyFileBoard(BoardDto board, List<MultipartFile> uploadFiles) {
        return 0;
    }
}
