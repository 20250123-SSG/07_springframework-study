package com.ibe6.di.run;

import com.ibe6.di.controller.PhoneController1;
import com.ibe6.di.controller.PhoneController2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext ctx = new GenericXmlApplicationContext("classpath:spring-context.xml");

        /*
        PhoneController1 pc1 = ctx.getBean("phoneController1", PhoneController1.class);
        //System.out.println(pc1);

        pc1.diTest();
        */

        PhoneController2 pc2 = ctx.getBean("phoneController2", PhoneController2.class);
        pc2.diTest();

    }
}