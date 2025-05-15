package com.minkook.ioc.section01.xmlconfig;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class Application {
    public static void main(String [] args){
        //spring 사용중
        Calculator calc1 = new Calculator();

        // *spring 사용한 후 : 스프링 컨테이너가 미리 생성해둔 bean 객체를 가져다가 사용
        // 1)Ioc 컨테이너 생성 : 빈 등록 구분이 쓰여있는 xml 파일의 경로를 제시하면서 (해당 파일을 로드해야함)
        ApplicationContext ctx = new GenericXmlApplicationContext("classpath:section01/spring-context.xml");

        //2_1 빈의 id를 이용해서 가져오기
        Calculator calc2 = (Calculator) ctx.getBean("calculator");

//        calc2.plus(2,3);
//        calc2.minus(4,2);
//        calc2.mul(5,2);
//        calc2.div(6,2);

//        Student st1 = ctx.getBean("student1",Student.class);
//        Student st2 = ctx.getBean("student2",Student.class);
//        Student st3 = ctx.getBean("student3",Student.class);
//
//        System.out.println(st1);
//        System.out.println(st2);
//        System.out.println(st3);

//        // * spring 사용후 : 빈으로 등록해두면 한번만 객체를 생성해두고 매번 재사용 가능
//        StudentService service1 = ctx.getBean("studentService",StudentService.class);
//        System.out.println(service1);
//        // 두 번째 요청
//        StudentService service2 = ctx.getBean("studentService",StudentService.class);
//        System.out.println(service2);
    }
}
