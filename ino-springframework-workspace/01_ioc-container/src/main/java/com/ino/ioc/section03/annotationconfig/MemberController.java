package com.ino.ioc.section03.annotationconfig;

import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    public void getMember(){
        System.out.println("MemberController's getMember()");
    }
}
