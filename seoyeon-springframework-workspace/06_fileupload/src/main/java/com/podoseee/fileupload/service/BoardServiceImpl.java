package com.podoseee.fileupload.service;
import com.podoseee.fileupload.util.FileUtil;

import com.podoseee.fileupload.dao.BoardMapper;
import com.podoseee.fileupload.dto.AttachmentDto;
import com.podoseee.fileupload.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
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

    private final SqlSessionTemplate sqlSession;
    private final FileUtil fileUtil;
    /**
     *  서비스에서 처리할거임
     * 1. tbl_board insert
     * 2. 첨부파일 업로드(저장)
     * 3. tbl_attachment insert
     */

    @Override
    public int registOneFileBoard(BoardDto board, MultipartFile uploadFile) {
        BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);

        // tbl_board insert
        int result = boardMapper.insertBoard(board); // 글번호 생성 => board의 boardNo 담겨있음

        // 첨부파일이 있을 경우 => 첨부파일 업로드 + tbl_attachment insert
        if(result > 0 && uploadFile != null && !uploadFile.getOriginalFilename().equals("")){
            // 1. 첨부파일 업로드
            Map<String, String> map = fileUtil.fileupload(uploadFile);

            // 2. tbl_attachment insert (db에 기록 - 저장경로, 원본명, 실제저장된파일명(수정명), 참조게시글번호)
            AttachmentDto attach = AttachmentDto.builder()
                    .filePath(map.get("filePath"))
                    .originalName(map.get("originalFilename"))
                    .filesystemName(map.get("filesystemName"))
                    .refBoardNo(board.getBoardID())
                    .build();

            result = boardMapper.insertAttach(attach);
        }

        return result;
    }

    @Override
    public int registManyFileBoard(BoardDto board, List<MultipartFile> uploadFiles) {

        BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);

        int result = boardMapper.insertBoard(board); // 게시글 table에 먼저 insert => 글번호 생성

        if(result > 0 && uploadFiles != null){
            for(MultipartFile uploadFile : uploadFiles){
                if(uploadFile != null && !uploadFile.getOriginalFilename().equals("")){

                    // 파일 업로드
                    Map<String, String> map = fileUtil.fileupload(uploadFile);
                    // db에 정보기록
                    AttachmentDto attach = AttachmentDto.builder()
                            .filePath(map.get("filePath"))
                            .originalName(map.get("originalFilename"))
                            .filesystemName(map.get("filesystemName"))
                            .refBoardNo(board.getBoardID())
                            .build();
                    result += boardMapper.insertAttach(attach);
                }
            }
        }

        return result;
    }
}














