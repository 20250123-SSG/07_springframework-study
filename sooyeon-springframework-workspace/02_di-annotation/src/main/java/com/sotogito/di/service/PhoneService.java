package com.sotogito.di.service;

import org.springframework.stereotype.Service;

//@Service
/**
 * 서비스 인터페이스는 구현체 없이 기능 정의만 제공하는 계약(contract) 역할을 함.
 * 따라서 @Service 애노테이션을 인터페이스에 붙여도 Spring은 실제 인스턴스를 생성할 수 없고, 빈으로 등록되지 않음.
 *
 *  Spring은 실제 구현체를 빈으로 등록해야 의존성 주입을 할 수 있으므로 impl된 클래스에 달아야함
 */
public interface PhoneService {

    //  전체 폰 조회
    void selectPhoneList();

    // 폰 한개 조회
    void selectDetail();

}
