package com.johnth.fileupload.service;

import com.johnth.fileupload.dao.BoardMapper;
import com.johnth.fileupload.dto.AttachmentDTO;
import com.johnth.fileupload.dto.BoardDTO;
import com.johnth.fileupload.util.FileUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final SqlSessionTemplate sqlSessionTemplate;
    private final FileUtil fileUtil;

    @Override
    public int registOneFileBoard(BoardDTO boardDTO, MultipartFile uploadFile) {
        BoardMapper boardMapper = sqlSessionTemplate.getMapper(BoardMapper.class);

        int result = boardMapper.insertBoard(boardDTO);

        if (result >= 1 && uploadFile != null && !uploadFile.getOriginalFilename().equals("")) {

            Map<String, String> map = fileUtil.fileupload(uploadFile);

            AttachmentDTO attachmentDTO = AttachmentDTO.builder()
                    .filePath(map.get("filePath"))
                    .originalName(map.get("originalFilename"))
                    .filesystemName(map.get("filesystemName"))
                    .refBoardNo(boardDTO.getBoardNo())
                    .build();

            result = boardMapper.insertAttach(attachmentDTO);
        }

        return result;
    }

    @Override
    public int registManyFileBoard(BoardDTO boardDTO, MultipartFile uploadFile) {
        return 0;
    }
}
