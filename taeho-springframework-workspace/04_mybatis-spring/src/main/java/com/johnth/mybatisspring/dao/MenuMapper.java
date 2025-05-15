package com.johnth.mybatisspring.dao;

import com.johnth.mybatisspring.dto.MenuDto;

import java.util.List;

public interface MenuMapper {
    //반환타입, 실행할 sql ID(sql에 사용할 변수)

    List<MenuDto> selectMenuList();
    MenuDto selectMenuById(int id);
    int insertMenu(MenuDto menu);
    int updateMenu(MenuDto menu);
    int deleteMenu(String[] codes);
}
