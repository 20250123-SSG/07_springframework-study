package com.sotogito.sbatis.service;

import com.sotogito.sbatis.dto.MenuDto;

import java.util.List;

public interface MenuService {

    List<MenuDto> getMenuAll();

    MenuDto getMenuByMenuCode(int menuCode);

    int registerMenu(MenuDto menuDto);

    int modifyMenu(MenuDto menuDto);

    int removeMenuByMenuCode(String[] menuCodes);

    /// 트랜젝션테스트용
    int registerTwoMenu();

}
