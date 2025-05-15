package com.ksh.ioc.section01.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {


        ApplicationContext ctx = new GenericXmlApplicationContext("classpath:section01/spring-context.xml");
        //Calculator calc2 = (Calculator) ctx.getBean("calculator");

        Calculator calc2 = ctx.getBean("calculator", Calculator.class);

        calc2.plus(2,3);
        calc2.minus(2,3);
        calc2.mul(2,3);
        calc2.div(2,3);

        Student stu1 = ctx.getBean("student1",Student.class);
        System.out.println(stu1);
        Student stu2 = ctx.getBean("student2",Student.class);
        System.out.println(stu2);
        Student stu3 = ctx.getBean("student3",Student.class);
        System.out.println(stu3);


        System.out.println("========================");
//        //spring사용 전
//        StudentService service1 = new StudentService();
//        System.out.println(service1);
//        //두번째 요우청
//        StudentService service2 = new StudentService();
//        System.out.println(service2);
//
        //spring 사용크
        StudentService service1 = ctx.getBean("studentService",StudentService.class);
        System.out.println(service1);

        StudentService service2 = ctx.getBean("studentService",StudentService.class);
        System.out.println(service2);



    }
}
