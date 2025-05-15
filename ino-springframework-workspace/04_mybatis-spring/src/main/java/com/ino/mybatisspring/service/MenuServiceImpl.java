package com.ino.mybatisspring.service;

import com.ino.mybatisspring.dao.MenuMapper;
import com.ino.mybatisspring.dto.MenuDto;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService{

    private final SqlSessionTemplate sqlSession;

    @Override
    public List<MenuDto> getAllMenu() {
        List<MenuDto> list = sqlSession.getMapper(MenuMapper.class).getAllMenu();
        return list;
    }

    @Override
    public MenuDto getMenuByCode(int code) {
        return sqlSession.getMapper(MenuMapper.class).getMenuByCode(code);
    }

    @Override
    public int insertMenu(MenuDto menu) {
        return sqlSession.getMapper(MenuMapper.class).insertMenu(menu);
    }

    @Override
    public int updateMenu(MenuDto menu) {
        return sqlSession.getMapper(MenuMapper.class).updateMenu(menu);
    }

    @Override
    public int deleteMenu(String[] codes) {
        return sqlSession.getMapper(MenuMapper.class).deleteMenu(codes);
    }
}
