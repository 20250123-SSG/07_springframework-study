package com.ssg.app.controller;

import com.ssg.app.dto.BoardDto;
import com.ssg.app.dto.UserDto;
import com.ssg.app.service.BoardService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/board")
@Controller
public class BoardController {

    private final BoardService boardService;

    /**
     * 메뉴 클릭시    : /board/list.page
     * 페이징바클릭시 : /board/list.page?page=X
     *
     * defaultValue값 설정으로 일반게시판 진입시 기본 page1 출력
     *
     *
     * # 게시글 목록페이지에 필요한 데이터
     * 1. 사용자가 요청한 페이지 출력시킬 게시글목록 데이터(db조회)
     * 2. 사용자가 요청한 페이지의 풀력시킬 페이징바의 정보
     */
    @GetMapping("/list.page")
    public String listPage(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
        log.info("----------------사용자가 요청한 페이지 번호 = {}", page);

        Map<String, Object> boardInfo = boardService.getBoardsAndPaging(page);
        model.addAttribute("boardList", boardInfo.get("boardList"));
        model.addAttribute("nowPage", boardInfo.get("nowPage"));
        model.addAttribute("totalPage", boardInfo.get("totalPage"));
        model.addAttribute("beginPage", boardInfo.get("beginPage"));
        model.addAttribute("endPage", boardInfo.get("endPage"));

        return "board/list";
    }


    @GetMapping("/regist.page")
    public String registPage() {
        return "board/regist";
    }

    @PostMapping("/regist.do")
    public String regist(@ModelAttribute BoardDto board,
                         HttpSession session,
                         @RequestParam List<MultipartFile> uploadfileList,
                         RedirectAttributes redirectAttributes) {

        int userNo = ((UserDto) session.getAttribute("loginUser")).getUserNo();
        board.setBoardWriter(String.valueOf(userNo));

        int result = boardService.registBoard(board, uploadfileList);
        redirectAttributes.addFlashAttribute("message", result > 0 ? "성공" : "실패");

        return "redirect:/board/list.page";
    }


    @GetMapping("/detail.page")
    public String detailPage(@RequestParam int no, Model model) {
        Map<String, Object> boardInfo = boardService.getBoardDetail(no);

        model.addAttribute("board", boardInfo.get("board"));
        model.addAttribute("attachList", boardInfo.get("attachList"));

        return "board/detail";
    }



}
