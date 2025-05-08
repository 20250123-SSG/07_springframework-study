package com.jjanggu.di.service;

import org.springframework.stereotype.Service;

@Service("phoneService")
public class PhoneServiceImpl_web implements PhoneService{

    @Override
    public void selectList() {
        System.out.println("웹 용 폰 전체 목록 조회용 서비스 실행");
    }

    @Override
    public void selectDetail() {
        System.out.println("웹용 폰 상제 조회용 서비스 실행");

    }
}
