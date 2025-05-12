package com.ibe6.sbatis.dao;

import com.ibe6.sbatis.dto.MenuDto;

import java.util.List;

public interface MenuMapper {
//    반환타입 실행한 sql의 id(sql전달할데이터);

    List<MenuDto> selectMenuList();
    MenuDto selectMenuByCode(int code);
    int insertMenu(MenuDto menu);
    int updateMenu(MenuDto menu);
    int deleteMenu(String[] codes);
}
