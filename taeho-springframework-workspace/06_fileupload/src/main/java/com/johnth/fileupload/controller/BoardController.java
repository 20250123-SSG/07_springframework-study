package com.johnth.fileupload.controller;

import com.johnth.fileupload.dto.BoardDTO;
import com.johnth.fileupload.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/board")
@Controller
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/regist1.do")
    public String registBoard1(BoardDTO boardDTO, @RequestParam MultipartFile uploadFile){
//        log.debug("board: {}", boardDTO.toString());
//        log.debug("uploadFile: {}", uploadFile);
//        log.debug("uploadFile: {}", uploadFile.getOriginalFilename());
        int result = boardService.registOneFileBoard(boardDTO, uploadFile);
        
        if(result > 0){
            log.debug("성공");
        } else {
            log.debug("실패");
        }

        return "redirect:/";
    }
}
