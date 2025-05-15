package com.inyong.sbatis.dao;

import com.inyong.sbatis.dto.MenuDto;

import java.util.List;

public interface MenuMapper {

    List<MenuDto> selectMenuList();
    MenuDto selectMenuByCode(int code);
    int insertMenu(MenuDto menu);
    int updateMenu(MenuDto menu);
    int deleteMenu(String[] codes);
}
