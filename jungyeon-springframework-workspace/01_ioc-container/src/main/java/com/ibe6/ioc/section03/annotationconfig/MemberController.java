package com.ibe6.ioc.section03.annotationconfig;

import org.springframework.stereotype.Component;

@Component
public class MemberController {
    public void getMember(){
        System.out.println("MemberController의 getMember실행??");
    }

}
