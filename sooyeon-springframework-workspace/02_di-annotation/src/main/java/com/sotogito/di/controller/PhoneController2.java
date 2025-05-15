package com.sotogito.di.controller;

import com.sotogito.di.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PhoneController2 {

    private PhoneService phoneService;

    /**
     * 하나의 인터페이스에 impl된 이름이 다른 클래스가 2개임
     * 해결방법 2. 각 imple된 클래스에 name을 정의하기
     * @param phoneService
     */
    @Autowired
    public PhoneController2(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    public void diTest() {
        //서비스 특 메서드 호출
    }

}
