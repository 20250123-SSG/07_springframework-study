package com.ino.fileupload.service;

import com.ino.fileupload.dto.BoardDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BoardService {
    // 단일 첨부파일 게시글 등록 서비스
    int registOneFileBoard(BoardDto board, MultipartFile mpf);

    // 다중 첨부파일 게시글 등록 서비스
    int registMultiFileBoard(BoardDto board, List<MultipartFile> mpfList);


}
