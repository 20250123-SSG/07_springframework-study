package com.ino.di.service;

import org.springframework.stereotype.Service;

@Service("phoneService")
public class PhoneServiceImpl_Web implements PhoneService {

    @Override
    public void selectList() {
        System.out.println("web phone get service");
    }

    @Override
    public void selectDetail() {
        System.out.println("web phone detail service");
    }
}
