package com.ino.mybatisspring.service;

import com.ino.mybatisspring.dto.MenuDto;

import java.util.List;

public interface MenuService {
    List<MenuDto> getAllMenu();

    MenuDto getMenuByCode(int code);

    int insertMenu(MenuDto menu);

    int updateMenu(MenuDto menu);

    int deleteMenu(String[] codes);
}
