package com.kyungbae.ioc.section01.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {

        // 객체 생성
        // 1. 일반적인 방법
        Calculator calc1 = new Calculator();

        // 2. Spring Framework 사용 (Bean 객체 사용)
        //  1) IoC 컨테이너 생성
        ApplicationContext ctx = new GenericXmlApplicationContext("classpath:section01/spring-context.xml");
        //  2_1) bean의 id로 가져오는 방법
        Calculator calc2 = (Calculator)ctx.getBean("calc");

        calc2.plus(2,3);
        calc2.minus(6, 2);
        calc2.mul(4, 3);
        calc2.div(1520439, 239);

        Student stu1 = ctx.getBean("student1", Student.class);
        System.out.println(stu1);

        Student stu2 = ctx.getBean("student2", Student.class);
        System.out.println(stu2);

        Student stu3 = ctx.getBean("student3", Student.class);
        System.out.println(stu3);

        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        /*
            요청에 따라서 객체를 자주 생성하는경우 매 객체 생성시 새롭게 생성되므로
            메모리를 과도하게 차지하게됨, 싱글턴 패턴으로 처리 가능함
            Spring bean 사용시에 자동으로 싱글턴 패턴으로 생성하기 때문에 효율적임
         */



    }
}
