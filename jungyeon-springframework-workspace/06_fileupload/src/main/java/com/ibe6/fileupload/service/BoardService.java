package com.ibe6.fileupload.service;

import com.ibe6.fileupload.dto.BoardDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BoardService {

    // 한개의 첨부파일이 있는 게시글 등록용 서비스
    int registOneFileBoard(BoardDto board, MultipartFile uploadFile);
    // 다수의 첨부파일이 있는 게시글 등록용 서비스
    int registManyFileBoard(BoardDto board, List<MultipartFile> uploadFiles);

}
