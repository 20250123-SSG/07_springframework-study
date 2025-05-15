package com.johnth.mybatisspring.service;

import com.johnth.mybatisspring.dto.MenuDto;

import java.util.List;

public interface MenuService {

    List<MenuDto> getMenuAll();

    MenuDto getMenuById(int id);

    int registMenu(MenuDto menuDto);

    int modifyMenu(MenuDto menuDto);

    int removeMenu(String[] codes);

    int registTwoMenu();
}
