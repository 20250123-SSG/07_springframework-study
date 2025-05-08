package com.kyungbae.ioc.section03.annotationconfig;

import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    public void getMember() {
        System.out.println("MemberController의 getMember 실행");
    }
}
