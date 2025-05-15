package com.sotogito.ioc.section01.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {

        /// spring 사용 전 : 개발자가 직접 필요한 객체를 생성해서 사용
        Calculator calc1 = new Calculator();

        ///  spring 사용 후 : 스프링 컨테이너가 미리 생성해둔 bean을 가져다가 사용
        /// 1) IoC 컨테이너 생성 : 빈 등록 구분이 쓰여있는 xml파일의 경로를 제시하면서
        ApplicationContext ctx = new GenericXmlApplicationContext("classpath:section01/spring-context.xml");
        /// 2_1) 빈의 id를 이용해서 가져오기
        Calculator calc2 = ctx.getBean("calculator", Calculator.class);

        calc2.plus(2,3);
        calc2.minus(2,3);
        calc2.div(2,3);
        calc2.mul(2,3);

        Student stu1 = ctx.getBean("student1", Student.class);
        System.out.println(stu1);

        Student stu2 = ctx.getBean("student2", Student.class);
        System.out.println(stu2);

        Student stu3 = ctx.getBean("student3", Student.class);
        System.out.println(stu3);


        System.out.println("1231231~!~!!!!!!!!!!!!!!!!!!!!!!!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        /// spring 사용 전 의존성 주입 -> 매번 new로 객체를 생성될 때마다 매번 객체가 생성되고 소멸됨
//        StudentService service1 = new StudentService();
//        StudentService service2 = new StudentService();

        /// 자주 사용하는 객체의 경우는 한번 생성하고 재사용 하는게 좋음 -> 싱글톤
        /// 서비스는 보통 실글톤으로 사용-> 서비스 싱글톤 답게 설계해야됨, 지역변수 조심해야할듯
        /**
         * 빈을 동록해놓으면 기본 scope가 싱글톤으로 생성됨
         * bean으로 등록해서 유리한 클래스가 있고 아닌 클래스가 있음
         * 싱글톤이 유리한 클래스 : 등록
         * 매번 인스턴스를 생성해야하는 클래스 : 안해도됨
         */
        StudentService service1 = ctx.getBean("studentService", StudentService.class);
        StudentService service2 = ctx.getBean("studentService", StudentService.class);
        
        if(service1 == service2) {
            System.out.println("주소값이 동일함");
        }


    }

}
