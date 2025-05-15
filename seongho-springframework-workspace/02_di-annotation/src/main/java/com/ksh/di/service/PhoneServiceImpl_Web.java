package com.ksh.di.service;

import org.springframework.stereotype.Service;

@Service("phoneService")
public class PhoneServiceImpl_Web implements PhoneService{
    @Override
    public void selectList() {
        System.out.println("웹용 폰 전체 조회");
    }

    @Override
    public void selectDetail() {
        System.out.println("웹용 폰 상세 조회");
    }
}
