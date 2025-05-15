package com.ino.fileupload.controller;

import com.ino.fileupload.dto.BoardDto;
import com.ino.fileupload.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController {
    @PostMapping("/regist1.do")
    public String registBoard1(BoardDto board, MultipartFile mpf){
        log.debug("board: {}", board);
        log.debug("multipartfile: {}",mpf);
        log.debug("multipartfile: {}",mpf.getOriginalFilename());
        int result = boardService.registOneFileBoard(board, mpf);

        if(result > 0) {
            log.debug("success regist board");
        } else {
            log.debug("failed regist board");
        }

        return "redirect:/";
    }

    @PostMapping("/regist2.do")
    public String registBoard2(BoardDto board, List<MultipartFile> mpf){
        int result = boardService.registMultiFileBoard(board, mpf);

        if(result == mpf.size()) {
            log.debug("success regist board");
        } else {
            log.debug("failed regist board");
        }

        return "redirect:/";
    }

    private final BoardService boardService;
}
