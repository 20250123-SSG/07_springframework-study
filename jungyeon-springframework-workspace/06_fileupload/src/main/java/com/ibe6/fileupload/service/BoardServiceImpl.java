package com.ibe6.fileupload.service;

import com.ibe6.fileupload.dao.BoardMapper;
import com.ibe6.fileupload.dto.AttachmentDto;
import com.ibe6.fileupload.dto.BoardDto;
import com.ibe6.fileupload.util.FileUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Map;


@Slf4j
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{

    private final SqlSessionTemplate sqlSession;
    private final FileUtil fileUtil;

    @Override
    public int registOnefileBoard(BoardDto board, MultipartFile uploadFile) {
        BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
        // tbl_board_insert
        int result = boardMapper.insertBoard(board); // 글번호 생성 => board의 boardNo 담겨있음

        // 첨부파일이 있을 경우 => 첨부파일 업로드 + tbl_attachment insert
        if (result > 0 && uploadFile != null && uploadFile.getOriginalFilename().equals("")) {
            // 1. 첨부파일 업로드
            Map<String, String> map = fileUtil.fileUpload(uploadFile);


            // 2. tbl_attachment insert (db에 기록 - 저장경로, 원본명, 실제저장된파일명(수정명), 참조게시글번호)
            AttachmentDto attach = AttachmentDto.builder()
                    .filePath(map.get("filePath"))
                    .originalName(map.get("originalFilName"))
                    .filesystemName(map.get("filesystemName"))
                    .refBoardNo(board.getBoardNo())
                    .build();

            result = boardMapper.insertAttach(attach);
        }

        return result;
    }

    @Override
    public int registManyFileBoard(BoardDto board, List<MultipartFile> uploadFiles) {
        return 0;
    }
}
