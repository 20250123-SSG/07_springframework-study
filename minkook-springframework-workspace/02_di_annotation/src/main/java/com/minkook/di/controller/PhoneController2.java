package com.minkook.di.controller;

import com.minkook.di.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PhoneController2 {

    @Autowired
    PhoneService phoneService;

    public void diTest(){
        phoneService.selectList();
        phoneService.selectDetail();
    }
}
