package com.ksh.di.run;

import com.ksh.di.controller.PhoneController1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext ctx = new GenericXmlApplicationContext("classpath:Spring-context.xml");
        PhoneController1 pc1 = ctx.getBean("phoneController1",PhoneController1.class);
        System.out.println(pc1);

        pc1.diTest();
    }
}
