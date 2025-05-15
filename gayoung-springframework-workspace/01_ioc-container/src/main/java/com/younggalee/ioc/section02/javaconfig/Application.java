package com.younggalee.ioc.section02.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLOutput;

public class Application {
    public static void main(String[] args) {
        // 빈등록구문이 작성되어 있는 java 파일을 로드하면서 ioc컨테이너 생성
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringBeanConfig.class);

        Music mu1 = ctx.getBean("music1", Music.class);
        Singer si1 = ctx.getBean("singer1", Singer.class);
        System.out.println(mu1);
        System.out.println(si1);
    }
}
