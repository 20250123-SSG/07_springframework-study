package com.ino.di.service;

import org.springframework.stereotype.Service;

public interface PhoneService {

    // 전체 폰 조회
    void selectList();

    // 폰 한개 조회
    void selectDetail();
}
