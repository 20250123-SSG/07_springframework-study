package com.johnth.webmvc.controller;

import com.johnth.webmvc.dto.MemberDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;

// 내부적으로 log 라는 이름의 객체생성
// private Logger logger = LoggerFactory.getLogger(MVCController.class)를 자동으로 작성
@Slf4j
@RequestMapping("/member")
@Controller
public class MemberController {
    // 1. HttpServletRequest 이용
    @GetMapping("/detail.do")
    public String memberDetail(HttpServletRequest request){
        int no = Integer.parseInt(request.getParameter("no"));

        // 상단의 @Slf4j 에서 log 생성
        log.debug("조회하고자 하는 번호 : " + no);

        return "redirect:/";
    }

    @PostMapping("/regist1.do")
    public String memberRegist1(HttpServletRequest request) throws UnsupportedEncodingException {
//        request.setCharacterEncoding("UTF-8"); => web.xml의 encodingFilter적용
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String addr = request.getParameter("address");

        log.debug("이름: " + name);
        log.debug("나이: {}", age);
        log.debug("주소: {}", addr);

        return "redirect:/";
    }

    @PostMapping("/regist2.do")
    public String memberRegist2(String name // @RequestParam(value="{value}") 생략가능, builder.gradle parameter설정 있을시
                                , @RequestParam(value = "age", defaultValue = "90") int age
                                , @RequestParam(value = "address") String addr)  {

        MemberDto mem = new MemberDto();
        mem.setName(name);
        mem.setAge(age);
        mem.setAddr(addr);
        log.debug("mem : {}", mem.toString());

        return "redirect:/";
    }

    // Command Object 방법
    @PostMapping("/regist3.do")
    public String memberRegist3(MemberDto mem)  {

        log.debug("mem : {}", mem.toString());
        //main.jsp의 name이 address로 MemberDto의 addr과 달라 null 이 출력됨(이름 통일)

        return "redirect:/";
    }
}
