package com.ksh.webmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping("/member")
@Controller

public class MemberController {

//    private Logger logger = LoggerFactory.getLogger(MemberController.class);

    @GetMapping("/detail.do")
    public String memberDetail(HttpServletRequest request){
        int no = Integer.parseInt(request.getParameter("no"));
        log.debug("no =" +no);
        return "redirect:/";
    }
    @PostMapping("/regist1.do")
    public String memberRegist1(HttpServletRequest request){
//        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String add = request.getParameter("add");

        log.debug("이름: "+name);
        log.debug("나이: "+age);
        log.debug("주소: "+add);

        return "redirect:/";
    }

}
