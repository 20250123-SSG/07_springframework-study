package com.younggalee.ioc.section01.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.objenesis.strategy.StdInstantiatorStrategy;

public class Application {
    public static void main(String[] args) {
        // *  Spring Framework 사용하기 전 : 개발자가 직접 필요한 객체를 생성해서 사용
        Calculator calculator = new Calculator();

        // * Spring Framework 사용한 후: 스프링 컨테이너가 미리 생성해둔 Bean 객체를 가져다가 사용
        // 1) IoC 컨테이너 생성 : 빈 등록 구문이 쓰여있는 xml 파일의 경로를 제시하면서 (해당 파일을 로드해야됨)
        ApplicationContext ctx = new GenericXmlApplicationContext("classpath:section01/spring-context.xml");
        // 2-1) 빈의 id를 이용해서 가져오기
//        Calculator calc2 = (Calculator) ctx.getBean("calculator");

        // 2-2) 등록된 빈의 id와 클래스 메타정보를 통해 가져오기
        Calculator calc2 = ctx.getBean("calculator", Calculator.class);
        calc2.plus(2,3);
        calc2.minus(3,1);

        Student stu2 = ctx.getBean("student2", Student.class);
        System.out.println(stu2);

        System.out.println("============================================");

        // * Spring 사용전에는 요청이 있을때마다 studentService객체를 new로 매번 생성했음.
        // 자주 사용되는 객체 > 한번 생성하고 재사용하는게 좋음 (싱글톤패턴) > Spring으로 빈을 한번 등록해두면 매번 재사용가능
        StudentService service1 = ctx.getBean("studentService", StudentService.class);
        System.out.println(service1 );
        // 주소값이 같다 > 한번 생성된 객체로 공유되며 사용됨


        }


}
