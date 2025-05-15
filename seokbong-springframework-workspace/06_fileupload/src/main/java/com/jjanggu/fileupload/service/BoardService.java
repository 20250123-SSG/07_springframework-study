package com.jjanggu.fileupload.service;

import com.jjanggu.fileupload.dto.BoardDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BoardService {
    // 단수 파일 글등록
    int registOneFileBoard(BoardDto board, MultipartFile uploadFile);
    // 복수 파일 글등록
    int registManyFileBoard(BoardDto board, List<MultipartFile> uploadFiles);
}
