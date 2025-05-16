package com.ssg.app.service;

import com.ssg.app.dto.BoardDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface BoardService {
    Map<String, Object> getBoardsAndPaging(int page);

    int registBoard(BoardDto board, List<MultipartFile> uploadFiles);

    Map<String, Object> getBoardDetail(int no);
}