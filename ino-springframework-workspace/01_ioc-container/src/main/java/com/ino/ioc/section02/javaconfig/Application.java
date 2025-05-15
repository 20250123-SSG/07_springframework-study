package com.ino.ioc.section02.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

        Music mu1 = ctx.getBean("music1", Music.class);
        Singer si1 = ctx.getBean("singer1", Singer.class);
        System.out.println(mu1);
        System.out.println(si1);
    }
}
