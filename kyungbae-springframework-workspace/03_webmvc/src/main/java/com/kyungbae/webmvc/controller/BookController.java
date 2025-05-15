package com.kyungbae.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/book") // base url 설정
@Controller
public class BookController {

    @GetMapping(/*/book 생략 가능 (base url 설정으로인해)*/"/list.do")
    public String bookList() {
        System.out.println("/WEB-INF/views/book/list.jsp로 포워딩");
        return "book/list"; // 포워딩할 뷰 경로 반환
    }

    @RequestMapping(value = "/detail.do", method = RequestMethod.GET)
    public String bookDetail() {
        System.out.println("/WEB-INF/views/book/detail.jsp로 포워딩");
        return "book/detail";
    }

    @GetMapping("/modifyForm.do")
    public String bookModifyForm() {
        System.out.println("/WEB-INF/views/book/modifyFrom.jsp로 포워딩");
        return "book/modify";
    }

    @PostMapping("/modify.do")
    public String bookModify() {
        System.out.println("/WEB-INF/views/book/modify.jsp로 포워딩");
        return "redirect:/book/detail.do?no=x";
    }
/*
    1. 도서목록페이지(book/list.jsp) 에서 "도서등록페이지로이동" 버튼 추가
    2. 해당 버튼 클릭시 "/book/registForm.do" url 요청되도록 설정
        => 도서등록페이지(/WEB-INF/views/book/regist.jsp) 만들어서 띄우기 (폼요소작업)
    3. 도서 등록 페이지에서 "등록" submit 하는 순간
            "/book/regist.do" url 요청되도록 설정
                    => 도서목록페이지가 다시 보여지도록 작업
 */
}
