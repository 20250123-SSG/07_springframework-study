package com.ino.ioc.section01.xmlconfing;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        Calculator calc1 = new Calculator();

        // Spring Container가 생성해둔 Bean 객체를 사용
        // 1. IoC 컨테이너 생성 : 빈 등록 구문이 쓰여있는 경로 제시하며 생성
        ApplicationContext ctx = new GenericXmlApplicationContext("classpath:section01/spring-context.xml");
        // 2-1. 빈의 id를 이용해 가져오기
//        Calculator calc2 = (Calculator) ctx.getBean("calculator");
        Calculator calc2 = ctx.getBean("calculator", Calculator.class);

        calc2.plus(2,3);
        calc2.minus(2,3);
        calc2.div(2,3);
        calc2.mul(2,3);

        Student stu2 = ctx.getBean("student2", Student.class);
        System.out.println(stu2);
        Student stu3 = ctx.getBean("student3", Student.class);
        System.out.println(stu3);

        System.out.println("=========================================");


        StudentService service1 = ctx.getBean("studentService", StudentService.class);
    }
}
