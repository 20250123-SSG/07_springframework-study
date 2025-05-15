package com.podoseee.webmvc.controller;

import com.podoseee.webmvc.dto.MemberDto;
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

    //private Logger logger = LoggerFactory.getLogger(MemberController.class);

    // 1. HttpServletRequest 이용하는 방법
    @GetMapping("/detail.do")
    public String memberDetail(HttpServletRequest request){
        int no = Integer.parseInt(request.getParameter("no"));
        log.debug("조회하고자 하는 회원번호 : " + no);

        return "redirect:/";
    }

    @PostMapping("/regist1.do")
    public String memberRegist1(HttpServletRequest request){
        //request.setCharacterEncoding("UTF-8"); => 인코딩필터로 대체
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String addr = request.getParameter("address");

        log.debug("이름 : " + name);
        log.debug("나이 : {}", age);
        log.debug("주소 : {}", addr);

        return "redirect:/";
    }

    // 2. @RequestParam 사용 방법
    @PostMapping("/regist2.do")
    public String memberRegist2(/*@RequestParam(value="name")*/ String name
                              , @RequestParam(value="age", defaultValue="10") int age
                              , @RequestParam(value="address") String addr){
//        log.debug("이름 : {}", name);
//        log.debug("나이 : {}", age);
//        log.debug("주소 : {}", addr);

        MemberDto mem = new MemberDto();
        mem.setName(name);
        mem.setAge(age);
        mem.setAddr(addr);

        log.debug("mem : {}", mem);

        return "redirect:/";
    }

    // 3. 커맨드 객체 방법
    @PostMapping("/regist3.do")
    public String memberRegist3(MemberDto mem) {
        log.debug("mem : {}", mem);
        return "redirect:/";
    }
}
