package com.younggalee.ioc.section03.annotationconfig;

import org.springframework.stereotype.Service;

@Service
public class MemberService {

    public void getMember(){
        System.out.println("MemberService의 getMember실행");
    }
}
