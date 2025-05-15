package com.johnth.di_annotation.run;

import com.johnth.di_annotation.controller.PhoneController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("classpath:spring-context.xml");

        PhoneController phoneController1 = (PhoneController) context.getBean("phoneController", PhoneController.class);

        phoneController1.diTest();
    }
}
