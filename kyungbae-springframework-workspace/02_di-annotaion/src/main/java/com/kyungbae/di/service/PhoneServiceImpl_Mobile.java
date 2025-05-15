package com.kyungbae.di.service;

import org.springframework.stereotype.Service;

@Service
public class PhoneServiceImpl_Mobile implements PhoneService{
    @Override
    public void selectList() {
        System.out.println("폰 전체 목록 조회 모바일");
    }

    @Override
    public void selectDetail() {
        System.out.println("폰 상세 조회 모바일");
    }
}
