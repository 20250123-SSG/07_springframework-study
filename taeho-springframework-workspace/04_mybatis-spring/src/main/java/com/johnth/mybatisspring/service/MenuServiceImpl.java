package com.johnth.mybatisspring.service;

import com.johnth.mybatisspring.dao.MenuMapper;
import com.johnth.mybatisspring.dto.MenuDto;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@RequiredArgsConstructor
@Service
public class MenuServiceImpl implements MenuService {

    private final SqlSessionTemplate sqlSession;

    @Override
    public List<MenuDto> getMenuAll() {
        return sqlSession.getMapper(MenuMapper.class).selectMenuList();
    }

    @Override
    public MenuDto getMenuById(int code) {
        return sqlSession.getMapper(MenuMapper.class).selectMenuById(code);
    }

    @Override
    public int registMenu(MenuDto menu) {
        return sqlSession.getMapper(MenuMapper.class).insertMenu(menu);
    }

    @Override
    public int modifyMenu(MenuDto menu) {
        return sqlSession.getMapper(MenuMapper.class).updateMenu(menu);
    }

    @Override
    public int removeMenu(String[] codes) {
        return sqlSession.getMapper(MenuMapper.class).deleteMenu(codes);
    }

    @Override
    public int registTwoMenu() {

        MenuDto m1 = new MenuDto().builder().menuName("menu1").menuPrice(2500).categoryCode(2).orderStatus("Y").build();
        MenuDto m2 = new MenuDto().builder().menuName("menu2").menuPrice(2500).categoryCode(2).orderStatus("YY").build();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        int r1 = menuMapper.insertMenu(m1);
        int r2 = menuMapper.insertMenu(m2);
        return r1 + r2;
    }
}