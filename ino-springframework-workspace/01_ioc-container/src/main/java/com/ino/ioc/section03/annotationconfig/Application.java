package com.ino.ioc.section03.annotationconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext ctx = new GenericXmlApplicationContext("classpath:/section03/spring-context.xml");
        Member m = ctx.getBean("member", Member.class);
        MemberController mc = ctx.getBean("memberController", MemberController.class);
        mc.getMember();
        MemberService ms = ctx.getBean("memberService", MemberService.class);
        ms.getMember();
    }
}
