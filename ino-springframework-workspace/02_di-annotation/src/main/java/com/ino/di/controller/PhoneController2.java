package com.ino.di.controller;

import com.ino.di.service.PhoneService;
import com.ino.di.service.PhoneServiceImpl_Web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PhoneController2 {
    @Autowired
    private PhoneService phoneService;
//
//    @Autowired
//    public PhoneController2(PhoneServiceImpl_Web impl) {
//        this.ps = impl;
//    }

    public void diTest(){
        phoneService.selectList();
        phoneService.selectDetail();
    }
}
