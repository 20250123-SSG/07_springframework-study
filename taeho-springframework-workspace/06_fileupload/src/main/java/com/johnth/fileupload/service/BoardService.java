package com.johnth.fileupload.service;

import com.johnth.fileupload.dto.BoardDTO;
import org.springframework.web.multipart.MultipartFile;

public interface BoardService {
    int registOneFileBoard(BoardDTO boardDTO, MultipartFile uploadFile);
    int registManyFileBoard(BoardDTO boardDTO, MultipartFile uploadFile);
}
