package com.sotogito.webmvc.controller;

import com.sotogito.webmvc.dto.MemberDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@Slf4j
@RequestMapping("/member")
@Controller
public class MemberController {

    /// 1. HttpServeltRequest
    @GetMapping("/detail.do")
    public String memberDetail(HttpServletRequest request) {
        int no = Integer.parseInt(request.getParameter("no"));
        log.debug("조회하고자하는 회원 번호 " + no);                   //조회하고자하는 회원 번호 1

        return "redirect:/";
    }

    /// 2. HttpServletRequest
    @PostMapping("/regist1.do")
    public String memberRegist1(HttpServletRequest request) {
//        request.setCharacterEncoding("UTF-8"); ///=>>>>> post 방식떄마다 인코딩을 해줘야함 -> filter 적용
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");

        log.debug("이름{} 나이{} 주소{}", name, age, address);

        return "redirect:/";
    }

    /// 3. RequestParam
    @PostMapping("/regist2.do")
    public String memberRegist2(String name,
                                @RequestParam(value = "age", defaultValue = "0") int age,
                                @RequestParam("address") String address) {
        /**
         * 만약 입력하지 않을 경우 빈문자열로 반환된다.
         * age의 경우는 Integer.parseInt하는 과정에서 400 오류가 뜬다.
         * 때문에 기본값을 작성해줘야한다.
         */

        MemberDto member = MemberDto.builder()
                                    .name(name)
                                    .age(age)
                                    .address(address)
                                    .build();

        log.debug("member: {}", member);

        return "redirect:/";
    }

    /// 4. 커맨드 객체 방법
    @PostMapping("/regist3.do")
    public String memberRegist3(MemberDto member) {
        log.debug("member: {}", member);

        return "redirect:/";
    }

}
