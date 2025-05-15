package com.kyungbae.webmvc.controller;

import com.kyungbae.webmvc.dto.MemberDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@RequestMapping("/member")
@Controller
public class MemberController {

    // private Logger logger = LoggerFactory.getLogger(MemberController.class); // lombok 으로 대체 가능 (@Slf4j)

    // 1. HttpServletRequest 이용하는 방법
    @GetMapping("/detail.do")
    public String memberDetail(HttpServletRequest request){
        int no = Integer.parseInt(request.getParameter("no"));
        log.debug("조회하고자 하는 회원번호 : " + no);
        return "redirect:/"; // 메인페이지로 이동
    }

    @PostMapping("/regist1.do")
    public String memberRegist1(HttpServletRequest request){
//        request.setCharacterEncoding("UTF-8"); // web.xml에 encodingFilter 전역 추가
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
    private String memberRegist2(String name, // parameter 명과 인자명이 같으면 자동으로 주입시킴
                                 @RequestParam(value="age", defaultValue = "10") int age, // int형 경우 빈값이 들어올 경우 오류발생
                                 @RequestParam("address") String addr){ // @RequestParam에 value값만 작성할 경우 value= 생략가능

        MemberDto mem = new MemberDto();
        mem.setName(name);
        mem.setAge(age);
        mem.setAddress(addr);

        log.debug("mem: {}", mem);

        return "redirect:/";
    }

    // 3. 커맨드 객체 방법 (Dto 주입)
    @PostMapping("/regist3.do")
    public String memberRegist3(MemberDto mem){
        log.debug("mem: {}", mem);

        return "redirect:/";
    }

}
