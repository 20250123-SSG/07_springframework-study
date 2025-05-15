package com.ksh.di.controller;

import com.ksh.di.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PhoneController2 {

//    private PhoneService phoneService
//            //= new PhoneServiceImpl_Web();
//            =new PhoneServiceImp_Mobile();
    @Autowired
    private PhoneService phoneService;

    public void diTest(){
        phoneService.selectDetail();
        phoneService.selectList();
    }


}
