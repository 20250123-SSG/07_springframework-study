package com.sotogito.fileupload.controller;

import com.sotogito.fileupload.dto.BoardDto;
import com.sotogito.fileupload.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/board")
@Controller
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/regist1.do")
    public String registBoard1(@ModelAttribute BoardDto board, @RequestParam MultipartFile uploadFile) {
//        log.debug("registBoard1: {}", board);
//        log.debug("uploadFile: {}", uploadFile);
//        log.debug("uploadFile.getOriginalFilename(): {}", uploadFile.getOriginalFilename());

        boolean isSuccess = boardService.registOneFileBoard(board, uploadFile) > 0;
        if (isSuccess) {
            log.debug("성공");
        } else {
            log.debug("실패");
        }

        return "redirect:/";
    }

    @PostMapping("/regist2.do")
    public String registBoard2(@ModelAttribute BoardDto board, @RequestParam List<MultipartFile> uploadFiles) {
        boolean isSuccess = boardService.registManyFileBoard(board, uploadFiles) == (uploadFiles.size() + 1);

        if (isSuccess) {
            log.debug("게시글 등록 성공");
        } else {
            log.debug("게시글 등록 실패");
        }

        log.debug("board = {}", board);
        log.debug("uploadFiles = {}", uploadFiles);

        return "redirect:/";
    }
}
