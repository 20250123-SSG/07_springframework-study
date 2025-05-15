package com.ibe6.ioc.section01.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class StudentService {

    public void getStudentAll(){
        System.out.println("학생 전체 조회용 비즈니스 로직 실행");

        System.out.println("========================");

        /*
           * Spring 사용전
        // 첫번째 요청
        StudentService service1 = new StudentService();
        System.out.println(service1);
        // 두번째 요청
        StudentService service2 = new StudentService();
        System.out.println(service2);
        // 10000건의 요청이 들어올 경우 new로 Service객체를 생성하도록 하면
        // 10000건의 객체가 생성됐다가 소멸됨을 반복함
        // 자주 사용되는 객체 => 한번 생성해두고 재사용 하는게 좋음 (싱글콘패턴)
        */

        // * Spring 사용후 : 빈으로 등록해두면 한번만 객체를 생성해두고 매번 재사용 가능
        ApplicationContext ctx = new GenericXmlApplicationContext("classpath:section01/spring-context.xml");
        // 첫번째 요청
        StudentService service1 = ctx.getBean("studentService", StudentService.class);
        System.out.println(service1);
        // 두번째 요청
        StudentService service2 = ctx.getBean("studentService", StudentService.class);
        System.out.println(service2);
        // 주소값이 같음 == 한번 생성된 객체로 공유되며 사용됨
    }
}
