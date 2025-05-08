package com.ksh.di.service;

import org.springframework.stereotype.Service;

@Service
public class PhoneServiceImpl_Mobile implements PhoneService{
    @Override
    public void selectList() {
        System.out.println("모바일용 전체 조회");
    }

    @Override
    public void selectDetail() {
        System.out.println("모바일용 상세 조회");
    }
}
