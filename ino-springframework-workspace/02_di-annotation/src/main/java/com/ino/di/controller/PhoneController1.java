package com.ino.di.controller;

import com.ino.di.dto.Phone;
import com.ino.di.service.PhoneService1;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PhoneController1 {

    private Phone p1;
    private Phone p2;
    private PhoneService1 ps1;

    @Autowired
    public PhoneController1(Phone phone1, Phone phone2,PhoneService1 ps1){
        this.p1 = phone1;
        this.p2 = phone2;
        this.ps1 = ps1;
    }
//
//    @Autowired
//    public void setA(Phone p1, PhoneService1 ps1){
//        this.p1 = p1;
//        this.ps1 = ps1;
//    }


    public void diTest(){
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println("di Test Complete");
//        ps1.diTest();
    }
}
