package com.younggalee.fileupload.service;

import com.younggalee.fileupload.dao.BoardMapper;
import com.younggalee.fileupload.dto.AttachmentDto;
import com.younggalee.fileupload.dto.BoardDto;
import com.younggalee.fileupload.util.FileUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.FileSystem;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{
    private final SqlSessionTemplate sqlSession; //생성자주입방식 (final, @RequiredArgsConstructor : 자동)
    private final FileUtil fileUtil;

    @Override
    public int registOneFileBoard(BoardDto board, MultipartFile uploadFile) {
        BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);

        // tbl_board insert
        int result = boardMapper.insertBoard(board); //글번호 생성 > board의 boardNo 담겨있음
        // 첨부파일이 있을 경우 => 첨부파일 업로드 + tbl_attachment insert
        if(result > 0 && uploadFile != null && !uploadFile.getOriginalFilename().equals("")){
            // 1. 첨부파일 업로드
                // 1) 저장경로 (/upload/board/yyyyMMdd)
            String filePath = "/upload/board" + DateTimeFormatter.ofPattern("/yyyyMMdd").format(LocalDate.now());
            File filePathDir = new File("C:" + filePath);
            if(!filePathDir.exists()){  // 해당경로의 폴더가 존재하지 않을 경우
                filePathDir.mkdirs();   // 해당폴더 만들기
            }
                // 2) 파일명 수정작업
            String originalFilename = uploadFile.getOriginalFilename(); // avl.wid.jpg
            String ext = originalFilename.substring(originalFilename.lastIndexOf("."));  // .jpg
            String filesystemName = UUID.randomUUID().toString().replace("-", "") + ext;

            log.debug("filesystemName : {}" , filesystemName);

            // 2. tbl_attachment insert

        }
        return 0;
    }

    @Override
    public int registManyFileBoard(BoardDto board, List<MultipartFile> uploadFiles) {
        BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
        int result = boardMapper.insertBoard(board); //글번호 생성 > board의 boardNo 담겨있음
        if(result > 0 && uploadFiles != null ){
            for (MultipartFile uploadFile : uploadFiles){
                if(uploadFile != null && !uploadFile.getOriginalFilename().equals("")){
                    //파일 업로드
                    Map<String, String> map = fileUtil.fileupload(uploadFile);
                    // db에 정보기록
                    AttachmentDto attach = AttachmentDto.builder()
                            .filePath(map.get("filePath"))
                            .originalName(map.get("originalFilename"))
                            .filesystemName(map.get("filesystemName"))
                            .refBoardNo(board.getBoardNo())
                            .build();
                    result += boardMapper.insertAttach(attach);
                    fileUtil
                }
            }
        }

}
