package com.sotogito.ioc.section02.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringBeanConfig.class); //Configuration 사용

        Music mu1 = ctx.getBean("music1", Music.class);
        Singer si1 = ctx.getBean("singer1", Singer.class);
        System.out.println(mu1);
        System.out.println(si1);

        Music mu2 = ctx.getBean("music2", Music.class);
        Singer si2 = ctx.getBean("singer2", Singer.class);
        System.out.println(mu2);
        System.out.println(si2);
    }
}
