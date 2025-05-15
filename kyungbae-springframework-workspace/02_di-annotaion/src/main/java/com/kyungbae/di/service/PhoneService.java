package com.kyungbae.di.service;

import org.springframework.stereotype.Service;

public interface PhoneService {

    // 전체 폰 조회
    void selectList();

    // 한개 폰 조회
    void selectDetail();

}
