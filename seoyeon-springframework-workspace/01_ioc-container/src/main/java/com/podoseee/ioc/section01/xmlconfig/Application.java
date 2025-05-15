package com.podoseee.ioc.section01.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {

        // * Spring Framework 사용하기 전 : 개발자가 직접 필요한 객체를 생성(new)해서 사용
        Calculator calc1 = new Calculator();

        // * Spring Framework 사용한 후 : 스프링 컨테이너가 미리 생성해둔 Bean 객체를 가져다가 사용
        // 1) IoC 컨테이너 생성 : 빈등록 구문이 쓰여있는 xml 파일의 경로를 제시하면서 (해당 파일을 로드해야됨)
        ApplicationContext ctx = new GenericXmlApplicationContext("classpath:section01/spring-context.xml");
        // 2_1) 빈의 id를 이용해서 가져오기
        // Calculator calc2 = (Calculator)ctx.getBean("calculator");
        // 2_2) 등록된 빈의 id와 클래스 메타정보를 통해 가져오기
        Calculator calc2 = ctx.getBean("calculator", Calculator.class);

        calc2.plus(2, 3);
        calc2.minus(4, 2);
        calc2.mul(5, 2);
        calc2.div(6, 2);

        Student stu1 = ctx.getBean("student1", Student.class);
        System.out.println(stu1);

        Student stu2 = ctx.getBean("student2", Student.class);
        System.out.println(stu2);

        Student stu3 = ctx.getBean("student3", Student.class);
        System.out.println(stu3);

        System.out.println("====================================================");

        // * Spring 사용전
        /*
        // 첫 번째 요청
        StudentService service1 = new StudentService();
        System.out.println(service1);
        // 두 번째 요청
        StudentService service2 = new StudentService();
        System.out.println(service2);
        // 10000건의 요청이 들어올 경우 new로 Service객체를 생성하도록 하면
        // 10000개의 객체가 생성됐다가 소멸됨을 반복함
        // 자주 사용되는 객체 => 한 번 생성해두고 재사용 하는 게 좋음 (싱글톤패턴)
        */

        // * Spring 사용 후 : 빈으로 등록해두면 한 번만 객체를 생성해두고 매번 재사용 가능
        // 첫 번째 요청
        StudentService service1 = ctx.getBean("studentService", StudentService.class);
        System.out.println(service1);
        // 두 번째 요청
        StudentService service2 = ctx.getBean("studentService", StudentService.class);
        System.out.println(service2);
        // 주소값이 같음 == 한번 생성된 객체로 공유되며 사용됨

    }
}
