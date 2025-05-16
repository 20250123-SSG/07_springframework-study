package com.ssg.app.controller;

import com.ssg.app.dto.BoardDto;
import com.ssg.app.dto.UserDto;
import com.ssg.app.service.BoardService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@RequestMapping("/board")
@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list.page") // 메뉴 클릭시 : /board/list.page : 페이징바 클릭시 : /board/list.page?page=x
    public void boardListPage(@RequestParam(value = "page", defaultValue = "1") int page, Model model){
        log.debug("page num user requested: {}", page);

        // 게시판 목록페이지 필요 데이터
        // 1. 사용자 요청 페이지 출력시킬 게시글 목록 데이터(db 조회)
        // 2. 사용자가 요청한 페이지에 출력시킬 페이징 바 정보
        Map<String, Object> map = boardService.getBoardsAndPaging(page);

        model.addAttribute("list", map.get("list")); // ${list} => List<BoardDto>
        model.addAttribute("page", map.get("page")); // ${page}
        model.addAttribute("totalPage", map.get("totalPage"));
        model.addAttribute("beginPage", map.get("beginPage"));
        model.addAttribute("endPage", map.get("endPage"));
    }

    @GetMapping("/regist.page")
    public void boardRegistPage(){}

    @PostMapping("/regist.do")
    public String boardRegist(BoardDto board, HttpSession session, List<MultipartFile> uploadFiles, RedirectAttributes ra){
        UserDto loginUser = (UserDto) session.getAttribute("loginUser");
        board.setBoardWriter(String.valueOf(loginUser.getUserNo()));

        int result = boardService.registBorad(board, uploadFiles);
        ra.addFlashAttribute("message", result > 0 ? "regist Success" : "regist Fail");

        return "redirect:/board/list.page";
    }

    @GetMapping("/detail.page")
    public void boardDetailPage(int no, Model model){

    }
}
