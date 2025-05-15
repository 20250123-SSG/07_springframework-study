package com.kyungbae.di.controller;

import com.kyungbae.di.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PhoneController2 {

    @Autowired
    private PhoneService phoneService;

    public void diTest() {
        // 서비스 메소드 호출
    }

}
