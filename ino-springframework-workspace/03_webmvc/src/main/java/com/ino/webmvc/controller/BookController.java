package com.ino.webmvc.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@RequestMapping("/book")
@Controller
public class BookController {

    @RequestMapping(value = {"/test2", "/list.do"})
    public void getBookList(){
        System.out.println("getBookList method running");
//        return "/book/list"; // 포워딩 뷰 경로 반환
    }

    @RequestMapping(value = "/detail.do", method = RequestMethod.GET)
    public void getBookDetail(){
//        return "/book/detail";
    }

    @PostMapping("/modify.do")
    public String editBook(){
        System.out.println("redirect to /book/detail.do");
        return "redirect:/book/detail.do?no=x";
    }

    @RequestMapping(value = "/modifyForm.do", method = RequestMethod.GET)
    public String modifyBook(){
        return "/book/modify";
    }
}
