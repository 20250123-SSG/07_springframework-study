package com.sotogito.di.run;

import com.sotogito.di.controller.PhoneController1;
import com.sotogito.di.controller.PhoneController2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = new GenericXmlApplicationContext("classpath:spring-context.xml"); ///어노테이션 Bean 등록

//        PhoneController1 pc1 = ctx.getBean("phoneController1", PhoneController1.class);
//        pc1.diTest();


        PhoneController2 pc2 = ctx.getBean("phoneController2", PhoneController2.class);
        pc2.diTest();


    }


}
