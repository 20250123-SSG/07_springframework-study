package com.johnth.ioc.section01.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {

        // Before SpringFramework : 개발자가 직접 필요한 객체를 생성
        Calculator calculator1 = new Calculator();

        // After SpringFramework : 스프링 컨테이너가 미리 생성한 Bean 객체를 사용(D.I)
        ApplicationContext context = new GenericXmlApplicationContext("spring-context.xml");

        Calculator calculator2 = context.getBean("calculator", Calculator.class);

        calculator2.plus(2,3);
        calculator2.minus(1,2);
        calculator2.multiply(2,3);
        calculator2.divide(6,2);

        Student student = context.getBean("student1", Student.class);
        System.out.println(student);

        // new로 선언하는 경우, 계속 객체를 생성하고 소멸
        /*
        StudentService service = new StudentService();
        System.out.println(service);

        StudentService service2 = new StudentService();
        System.out.println(service2);
        */

        StudentService studentService = (StudentService) context.getBean("studentService");
        System.out.println(studentService);
        StudentService studentService2 = (StudentService) context.getBean("studentService");
        System.out.println(studentService2);
    }
}
