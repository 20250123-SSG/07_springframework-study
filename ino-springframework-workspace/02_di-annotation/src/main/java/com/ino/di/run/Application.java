package com.ino.di.run;

import com.ino.di.controller.PhoneController1;
import com.ino.di.controller.PhoneController2;
import com.ino.di.dto.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext ctx = new GenericXmlApplicationContext("classpath:Spring-context.xml");
//        PhoneController1 pc1 = ctx.getBean("phoneController1", PhoneController1.class);
//        System.out.println(pc1);
//        pc1.diTest();
//        Phone p1 = ctx.getBean("phone1", Phone.class);
//        System.out.println(p1.toString());

        PhoneController2 pc2 = ctx.getBean("phoneController2", PhoneController2.class);
        pc2.diTest();
    }
}
