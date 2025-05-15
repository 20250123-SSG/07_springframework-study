package com.younggalee.fileupload.controller;

import com.younggalee.fileupload.dto.BoardDto;
import com.younggalee.fileupload.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j//로그출력
@RequiredArgsConstructor
//기능별로 묶어서 관리하기 위해 해당 url로 시작되는 것들
@RequestMapping("/board")
@Controller
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/regist1.do")
    public String registBoard1(BoardDto board, MultipartFile uploadFile){
//        log.debug("board: {}", board);
//        log.debug("uploadFile: {}", uploadFile);
//        log.debug("uploadFile 원본명: {}", uploadFile.getOriginalFilename());
        // 서비스에서 진행
    //내용을 우선 게시판(tbl_board)에 인서트하고, 첨부파일 업로드(저장), tbl_attachment에도 인서트함 (트랜잭션)
        int result = boardService.registOneFileBoard(board, uploadFile);

        if(result > 0){
            log.debug("게시글 등록 성공");
        }else{
            log.debug("게시글 등록 실패");
        }

        return "redirect:/";
    }

    @PostMapping("/regist2.do")
    public String registBoard2(BoardDto board, List<MultipartFile> uploadFiles) {
        int result = boardService.registManyFileBoard(board, uploadFiles);

        if (result > 0){
            log.debug("게시글 등록 성공");
        } else {
            log.debug("게시글 등록 실패");
        }
        return "redirect:/";
    }
}
