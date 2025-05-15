package com.ino.mybatisspring.dao;

import com.ino.mybatisspring.dto.MenuDto;

import java.util.List;

public interface MenuMapper {
    List<MenuDto> getAllMenu();

    MenuDto getMenuByCode(int code);

    int insertMenu(MenuDto menu);

    int updateMenu(MenuDto menu);

    int deleteMenu(String[] codes);
}
