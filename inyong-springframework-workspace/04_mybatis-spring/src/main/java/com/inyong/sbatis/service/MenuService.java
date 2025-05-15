package com.inyong.sbatis.service;

import com.inyong.sbatis.dto.MenuDto;

import java.util.List;

public interface MenuService {

    // 전체 메뉴 목록 조히 서비스
    List<MenuDto> getMenuAll();

    // 메뉴 상세조회 서비스
    MenuDto getMenuByCode(int code);

    // 메뉴 등록 서비스
    int registMenu(MenuDto menu);

    // 메뉴 수정 서비스
    int modifyMenu(MenuDto menu);

    // 메뉴 일괄 삭제 서비스
    int removeMenu(String[] codes);

}
