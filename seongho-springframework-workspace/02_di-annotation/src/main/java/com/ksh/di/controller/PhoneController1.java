package com.ksh.di.controller;

import com.ksh.di.dto.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PhoneController1 {
    /*
    @Autowired
    private Phone a;

    public void diTest(){
        System.out.println(a);

    }


    private Phone a;

    @Autowired
    public void  setA(Phone abc){
        this.a =abc;
    }

    public void diTest(){
        System.out.println(a);
    }

    @Autowired
    private Phone phone;
    @Autowired
    private Phone phone2;
    public void diTest(){
        System.out.println(phone);
        System.out.println(phone2);
    }
    private Phone a;
    private Phone b;

    public PhoneController1(Phone phone,Phone phone2){
        this.a = phone;
        this.b = phone2;
    }

    public void diTest(){
        System.out.println(a);
        System.out.println(b);
    }     */
    private Phone a;
    private Phone b;

    @Autowired
    public void setA(Phone phone){
        this.a = phone;
    }

    @Autowired
    public void setB(Phone phone2){
        this.b = phone2;
    }
    public void diTest(){
        System.out.println(a);
        System.out.println(b);
    }

}
