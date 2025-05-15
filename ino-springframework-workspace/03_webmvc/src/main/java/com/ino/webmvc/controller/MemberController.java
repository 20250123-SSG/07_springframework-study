package com.ino.webmvc.controller;

import com.ino.webmvc.dto.MemberDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@RequestMapping("/member")
@Controller
public class MemberController {

    // 1. HttpServletRequest를 이용한 데이터 사용
    @GetMapping("/detail.do")
    public String detailView(HttpServletRequest req){
        int no = Integer.parseInt(req.getParameter("no"));
        log.debug("no : " + no);
        return "redirect:/";
    }

    @PostMapping("/regist1.do")
    public String regist1(HttpServletRequest req){

        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String addr = req.getParameter("addr");
        log.debug("regist name : " + name);
        log.debug("regist age : {}",age);
        log.debug("regist addr : " + addr);
        return "redirect:/";
    }

    @PostMapping("/regist2.do")
    public String regist2(String name
            , @RequestParam(defaultValue="10") int age, String addr){

        log.debug("regist name : " + name);
        log.debug("regist age : {}",age);
        log.debug("regist addr : " + addr);
        return "redirect:/";
    }

    @PostMapping("/regist3.do")
    public String regist3(MemberDto mem){

        log.debug("regist name : " + mem.getName());
        log.debug("regist age : {}",mem.getAge());
        log.debug("regist addr : " + mem.getAddr());
        return "redirect:/";
    }
}
