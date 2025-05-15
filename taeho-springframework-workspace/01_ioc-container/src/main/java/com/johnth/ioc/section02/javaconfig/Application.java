package com.johnth.ioc.section02.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringBeanConfig.class);

        Music music1 = (Music) context.getBean("music", Music.class);
        Singer singer1 = (Singer) context.getBean("singer", Singer.class);
        System.out.println(music1);
        System.out.println(singer1);

        Music music2 = (Music) context.getBean("music2", Music.class);
        Singer singer2 = (Singer) context.getBean("singer2", Singer.class);
        System.out.println(music2);
        System.out.println(singer2);
    }
}
