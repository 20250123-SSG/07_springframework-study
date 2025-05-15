package com.sotogito.ioc.section03.annotationconfig;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    public void getMember() {
        System.out.println("MemberController.getMember 실행");
    }

}
