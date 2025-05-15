package com.sotogito.di.controller;

import com.sotogito.di.dto.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller //id = phoneController1
public class PhoneController1 {
    /**
     * Autowired
     */
    /// 1. 필드를 이용해서 생성된 Bean주입
    @Autowired // Phone타입으로 된 Bean을 찾아서 자동 주입함
    private Phone phone;

    /// 2. 생성자를 이용해서 Bean 주입
//    @Autowired //생략 가능
//    public PhoneController1(Phone phone) { //해당 생성자가 자동으로 자료형에 따라 Bean 자동 주입
//        this.phone = phone;
//    }
    /// 3. 메서드를 이용해서 Bean 주입
//    @Autowired //일반 메서드로 Bean을 자동 주입하기 위해서는 어노테이션 필수, 없다면 spring 아닐때랑 똑같음
//    public void setPhone(Phone phone) { //일반 메서드이기 때문에 주입되기 위해서는 호출이 돼야함
//         this.phone = phone;
//    }

    public void diTest() {
        System.out.println(phone); //Phone(name=아이폰16pro, brand=Apple, price=1500000, releaseDate=2024-09-01)
    }


    /**
     * 동일한 타입의 Bean이 여러개일 경우
     *
     * id를 다르게 지정했지만 의존성을 주입할때 조건인 Phone자료형은 같기 때문에 처리해줘야한다.
     * NoUniqueBeanDefinitionException: No qualifying bean of type 'com.sotogito.di.dto.Phone' available: expected single matching bean but found 2: phone,phone2
     *
     * ### 해결법
     * 1. Autowired의 : 필드명을 주입받고자 하는 Bean의 id로 선언
     *      @Autowired의 경우 자동 주입할 때 [자료형 -> 필드명] 순으로 확인하여 자동주입하기 때문
     * 2. Inject(타입탐색) + @qulifier(이름탐색)
     */

    /// 1. 필드 주입 : 필드명을 주입받고자 하는 Bean의 id로 선언
//    @Autowired
//    private Phone phone1;
//    private Phone phone2;

    /// 2. 생성자 주입 : 생성자의 매개변수 자료형+매개변수명을 같게한다.
    private Phone p1;
    private Phone p2;

    public PhoneController1(Phone phone, Phone phone2) { //인텔리제이같은 경우 컴파일시 파라미터명을 임시적으로 변경하기 때문에 설정 변경해야됨
        this.p1 = phone;
        this.p2 = phone2;
    }

    public void setA(Phone phone1) {
        this.p1 = phone1;
    }



}
