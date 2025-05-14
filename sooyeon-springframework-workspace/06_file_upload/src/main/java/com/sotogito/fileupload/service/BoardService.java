package com.sotogito.fileupload.service;

import com.sotogito.fileupload.dto.BoardDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BoardService {

    int registOneFileBoard(BoardDto board, MultipartFile file);

    int registManyFileBoard(BoardDto board, List<MultipartFile> uploadFiles);
}
