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

        if (result > 0 && mpf != null && !mpf.getOriginalFilename().equals("")) {

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

        if (result > 0 && mpfList != null)
        for (int i = 0; i < mpfList.size(); i++) {
            if (mpfList.get(i) != null && !mpfList.get(i).getOriginalFilename().equals("")) {
                Map<String, String> map = fileUtil.fileupload(mpfList.get(i));
                AttachmentDto attachment = new AttachmentDto().builder()
                        .filePath(map.get("filePath"))
                        .originalName(map.get("orgFileName"))
                        .filesystemName(map.get("randUUID"))
                        .refBoardNo(board.getBoardNo())
                        .build();
                result += boardMapper.insertAttachment(attachment);
            }
        }
        return result;
    }
}
