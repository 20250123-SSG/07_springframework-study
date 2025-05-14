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
        }else {
            log.debug("실패");
        }

        return "redirect:/";


        /**
         *  서비스에서 처리할거임
         * 1. tbl_board insert
         * 2. 첨부파일 업로드(저장)
         * 3. tbl_attachment insert
         */
    }
}
