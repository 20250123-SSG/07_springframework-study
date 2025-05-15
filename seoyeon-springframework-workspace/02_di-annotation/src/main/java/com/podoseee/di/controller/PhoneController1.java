package com.podoseee.di.controller;

import com.podoseee.di.dto.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class PhoneController1 {


    // * @Autowired
    // 1) 필드를 이용해서 생성된 Bean 주입(DI)받기 : 필드 상단에 @Autowired 어노테이션 기술
    /*
    @Autowired
    private Phone a; // 기본적으로 타입을 가지고 빈을 탐색함 (즉, 필드명은 중요하지 않음)

    public void diTest(){
        System.out.println(a);
    }
     */

    // 2) 생성자를 이용해서 Bean 주입(DI)받기
    //    생성자에 주입받고자 하는 객체를 매개변수로 두면 해당 매개변수 타입을 가지고 DI가 진행됨
    //    @Autowired 생략 가능
    /*
    private Phone a;

    //@Autowired
    public PhoneController1(Phone abc){ // 해당 생성자가 자동으로 실행될때 매개변수에 DI 발생됨
        this.a = abc;
    }

    public void diTest(){
        System.out.println(a);
    }
     */

    // 3) 메소드를 이용해서 Bean 주입(DI)받기
    //    메소드의 매개변수로 주입받고자하는 Bean 객체를 매개변수로 둠
    //    @Autowired 필수로 작성해야됨
    /*
    private Phone a;

    @Autowired
    public void setA(Phone abc){ // 해당 메소드가 실행될 때 매개변수에 DI 발생됨
        this.a = abc;
    }

    public void diTest(){
        System.out.println(a);
    }
     */


    /*
        * 동일한 타입의 Bean이 여러개일 경우?
        @Autowired는 기본적으로 타입을 이용해서 빈 탐색을 하기 때문에 동일한 타입의 빈이 여러개일 경우
        오류를 유발시킴 (@Inject와 동일)

        => 필드명을 주입받고자 하는 빈의 이름(id)으로 작성 => 이름으로 빈을 탐색해서 주입해줌 (@Autowired에 내장되어있는 @Qualifier(식별자)의 기능)

        즉, 탐색 순서가 타입(class) => 이름(id)

        @Inject(타입탐색) + @Qualifier(이름탐색) == @Autowired
     */

    // 1) 필드 주입
    /*
    @Autowired
    private Phone phone1;
    @Autowired
    private Phone phone2;

    public void diTest(){
        System.out.println(phone1);
        System.out.println(phone2);
    }
     */

    // 2) 생성자 주입
    /*
    private Phone a;
    private Phone b;

    public PhoneController1(Phone phone1, Phone phone2){ // IntelliJ 같은 경우 컴파일시 파라미터명을 임의적으로 수정해서 제대로 진행이 안될 수 있음
        this.a = phone1;
        this.b = phone2;
    }

    public void diTest(){
        System.out.println(a);
        System.out.println(b);
    }
     */

    // 3) 메소드 주입
    private Phone a;
    private Phone b;

    @Autowired
    public void setA(Phone phone1){
        this.a = phone1;
    }
    @Autowired
    public void setB(Phone phone2){
        this.b = phone2;
    }

    public void diTest(){
        System.out.println(a);
        System.out.println(b);
    }

}