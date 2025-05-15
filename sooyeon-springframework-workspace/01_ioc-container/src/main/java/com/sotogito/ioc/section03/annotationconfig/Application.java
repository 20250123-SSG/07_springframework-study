package com.sotogito.ioc.section03.annotationconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

    public static void main(String[] args) {

        /// 어노테이션 등록된 파일 Bean등록
        ApplicationContext ctx = new GenericXmlApplicationContext("classpath:section03/spring-context.xml");

        Member member = ctx.getBean("member", Member.class);

        MemberController memberController = ctx.getBean("memberController", MemberController.class);
        memberController.getMember();

        MemberService memberService = ctx.getBean("memberService", MemberService.class);
        memberService.getMember();


    }
}
