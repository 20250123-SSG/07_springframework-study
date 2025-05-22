package com.sotogito.fileupload.service;

import com.sotogito.fileupload.dao.BoardMapper;
import com.sotogito.fileupload.dto.AttachmentDto;
import com.sotogito.fileupload.dto.BoardDto;
import com.sotogito.fileupload.util.FileUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.PipedReader;
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
        if (isUploadFileValid) {
            /// 저장경로
            Map<String, String> uploadResults = fileUtil.fileUpload(uploadFile);

            /// db에 저장 - tbl_attachment insert (저장명, 원본명, 수정명, 참조게시글번호)
            AttachmentDto attachment = AttachmentDto.builder()
                    .filePath(uploadResults.get("filePath"))
                    .originalName(uploadResults.get("originalName"))
                    .filesystemName(uploadResults.get("filesystemName"))
                    .refBoardNo(board.getBoardNo())
                    .build();
            insertResult = boardMapper.insertAttach(attachment);
        }

        return insertResult;
    }

    @Override
    public int registManyFileBoard(BoardDto board, List<MultipartFile> uploadFiles) {
        BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);

        int insertResult = boardMapper.insertBoard(board);

        boolean isUploadFileValid = (insertResult > 0 && uploadFiles != null && !uploadFiles.isEmpty());
        if (isUploadFileValid) {
            for (MultipartFile uploadFile : uploadFiles) {
                if (uploadFile != null && !uploadFile.getOriginalFilename().equals("")) {

                    Map<String, String> uploadResults = fileUtil.fileUpload(uploadFile);

                    insertResult += boardMapper.insertAttach(AttachmentDto.builder()
                            .filePath(uploadResults.get("filePath"))
                            .originalName(uploadResults.get("originalName"))
                            .filesystemName(uploadResults.get("filesystemName"))
                            .refBoardNo(board.getBoardNo())
                            .build());

                }
            }
        }
        return insertResult;
    }
}
