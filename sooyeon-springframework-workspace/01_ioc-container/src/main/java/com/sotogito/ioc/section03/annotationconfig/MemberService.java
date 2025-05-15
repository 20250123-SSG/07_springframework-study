package com.sotogito.ioc.section03.annotationconfig;

import org.springframework.stereotype.Service;

@Service
public class MemberService {

    public void getMember() {
        System.out.println("MemberService getMember 실행");
    }

}
