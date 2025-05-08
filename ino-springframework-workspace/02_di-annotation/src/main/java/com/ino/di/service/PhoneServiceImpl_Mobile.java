package com.ino.di.service;

import org.springframework.stereotype.Service;

@Service
public class PhoneServiceImpl_Mobile implements PhoneService{
    @Override
    public void selectList() {
        System.out.println("mobile select list");
    }

    @Override
    public void selectDetail() {
        System.out.println("mobile select detail");
    }
}
