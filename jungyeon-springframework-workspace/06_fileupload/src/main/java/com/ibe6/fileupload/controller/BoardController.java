package com.ibe6.fileupload.controller;

import com.ibe6.fileupload.dto.BoardDto;
import com.ibe6.fileupload.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/board")
@Controller
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/regist1.do")
    public void registBoard1(BoardDto board, MultipartFile uploadFile){
        //log.debug("board: {}", board);
        //log.debug("uploadFIle: {}", uploadFile);
        //log.debug("uploadFile 원본명: {}", uploadFile.getOriginalFilename());
        int result = boardService.registOnefileBoard(board, uploadFile);
        if(result > 0){
            log.debug("게시글 등록 성공");
        }else {
            log.debug("게시글 등록 실패");
        }
    }
}
