package com.kyungbae.di.controller;

import com.kyungbae.di.dto.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PhoneController1 {

    /*
    // @Autowired
    // 1) 필드를 이용해서 생성된 Bean 주입받기
    @Autowired
    private Phone a; // 타입을 가지고 bean 탐색 (필드명은 중요하지 않음)


    // 2) 생성자를 이용해서 Bean 주입받기
    //  생성자에 주입받고자 하는 객체를 매개변수로 두면 해당 매개변수 타입을 가지고 DI가 진행됨
    private Phone b;

    // @Autowired // 생략가능
    public PhoneController1(Phone abc) {
        this.b = abc;
    }

    // 3) 메소드를 이용해서 Bean 주입받기
    private Phone c;

    @Autowired
    public void setC(Phone abc) { // 해당 메소드가 실행될 때 매개변수에 DI 발생함
        this.c = abc;
    }



    public void diTest() {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
     */

    /*
        * 동일한 타입의 Bean이 여러개일 경우
        @Autowired는 기본적으로 타입을 이용해서 Bean 탐색을 하기 때문에 동일한 타입의 Bean이 여러개일 경우
        오류를 유발시킴 (Inject와 동일)

        => 필드명을 주입받고자 하는 빈의 id로 작성 => id로 Bean을 탐색해서 주입해줌
        탐색 순서가 타입(class) => 이름(id)

        @Inject(타입탐색) + @Qualifier(이름탐색) == @Autowired
     */

    // 1) 필드 주입
    @Autowired
    private Phone phone1;
    @Autowired
    private Phone phone2;

    // 2) 생성자 주입

    private Phone x;
    private Phone y;

    public PhoneController1(Phone phone1, Phone phone2) { // intellij 컴파일시 파라미터명을 임의적으로 수정해서 오류발생
        this.x = phone1;
        this.y = phone2;
    }

    // 3) 메소드 주입

    private Phone p1;
    private Phone p2;

    @Autowired
    public void setA(Phone phone1, Phone phone2) {
        this.p1 = phone1;
        this.p2 = phone2;
    }

    public void diTest() {
        System.out.println(phone1);
        System.out.println(phone2);
        System.out.println("=========================================================");
        System.out.println(x);
        System.out.println(y);
        System.out.println("=========================================================");
        System.out.println(p1);
        System.out.println(p2);
    }

}
