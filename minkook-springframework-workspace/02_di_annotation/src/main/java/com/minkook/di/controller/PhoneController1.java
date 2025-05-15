package com.minkook.di.controller;

import com.minkook.di.dto.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PhoneController1 {
    // * Autowired
    // 1) 필드를 이용해서 생성된 Bean 주입(DI) 받기 : 필드 상단에 @Autowired 어노테이션 기술
    /*@Autowired
    private Phone a;

    public void diTest(){
        System.out.println(a);
    }*/

    // 2) 생성자를 이용해서 Bean 주입받기

    /*
    private Phone a;

    public PhoneController1(Phone abc){
        this.a = abc;
    }

    public void diTest2(){
        System.out.println(a);
    }*/

    // 3) 메소드 이용해서 Bean 주입받기
    /*private Phone a;

    @Autowired
    public void setA(Phone abc){
        this.a = abc;
    }

    public void diTest3(){
        System.out.println(a);
    }*/

    /*
        동일한 타입의 Bean이 여러개일 경우?
        @Autowired는 기본적으로 타입을 이용해서 빈 탐색을 하기 때문에 동일한 타입의 빈이 여러개일 경우
        오류를 유발시킴(@Ingect와 동일)

        => 필드명을 주입받고자 하는 빈의 이름(id)으로 각성

     */

    // 1) Autowired
    // 1) Autowired
    /*@Autowired
    private Phone phone1;

    @Autowired
    private Phone phone2;


    public void diTest(){
        System.out.println(phone1);
        System.out.println(phone2);
    }*/

    
    // 2) 생성자 주입
    public Phone a;
    public Phone b;

    public PhoneController1(Phone phone1,Phone phone2){ //인텔리제이 같은 경우 컴파일시 파라미터명을 임의적으로 수정해서 제대로 진행안될수 도 있음
        this.a = phone1;
        this.b = phone2;
    }

    public void diTest(){
        System.out.println(a);
        System.out.println(b);
    }

}
