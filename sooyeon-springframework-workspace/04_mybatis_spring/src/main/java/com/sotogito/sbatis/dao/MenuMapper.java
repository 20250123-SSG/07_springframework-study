package com.sotogito.sbatis.dao;

import com.sotogito.sbatis.dto.MenuDto;

import java.util.List;

public interface MenuMapper {

    List<MenuDto> selectMenuList();

    MenuDto selectMenuByMenuCode(int menuCode);

    int insertMenu(MenuDto menuDto);

    int updateMenu(MenuDto menuDto);

    int deleteMenusByMenuCode(String[] codes);

}
