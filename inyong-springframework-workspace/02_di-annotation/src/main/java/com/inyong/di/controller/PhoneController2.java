package com.inyong.di.controller;

import com.inyong.di.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PhoneController2 {


    // * 스프링 사용전 : new 로 객체 생성 직접 진행
    /*
    private PhoneService phoneService
            = new PhoneServiceImpl_Web();  // 웹용 개발 당시
            //= new PhoneServiceImpl_Mobile(); // 모바일용 개발 당시
     */

    // * 스프링 사용후 : 사용할 Service객체를 Bean 등록한 후에 자동 주입되도록
    @Autowired
    private PhoneService phoneService;
    /*
        웹용, 모바일용 두개 모두 빈으로 등록되어있을 경우 오류 유발
        해결방법1. 개발 당시 사용하고 싶은 서비스 객체만 빈으로 등록하기
        해결방법2. 둘다 빈으로 등록을 해두되 개발 당시에 사용할 Service 빈의 이름만 phoneService로 해두기
     */

    public void diTest(){
        // 서비스 측 메소드 호출
        phoneService.selectList();
        phoneService.selectDetail();
    }

}
