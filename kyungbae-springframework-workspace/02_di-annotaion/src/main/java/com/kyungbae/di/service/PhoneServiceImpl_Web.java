package com.kyungbae.di.service;

public class PhoneServiceImpl_Web implements PhoneService{
    @Override
    public void selectList() {
        System.out.println("폰 전체 목록 조회 웹");
    }

    @Override
    public void selectDetail() {
        System.out.println("폰 상세 조회 웹");
    }
}
