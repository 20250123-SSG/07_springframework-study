package com.kyungbae.ioc.section02.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        // bean 등록 구문이 작성되어있는 Java 파일을 load 하면서 IoC 컨테이너 생성
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringBeanConfig.class);

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
