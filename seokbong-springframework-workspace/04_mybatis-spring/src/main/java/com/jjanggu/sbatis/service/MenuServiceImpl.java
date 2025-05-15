package com.jjanggu.sbatis.service;

import com.jjanggu.sbatis.dao.MenuMapper;
import com.jjanggu.sbatis.dto.MenuDto;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MenuServiceImpl implements MenuService{

    private final SqlSessionTemplate sqlSession;

    @Override
    public List<MenuDto> getMenuAll() {
        return sqlSession.getMapper(MenuMapper.class).selectMenuList();
    }

    @Override
    public MenuDto getMenuByCode(int code) {
        return sqlSession.getMapper(MenuMapper.class).selectMenuByCode(code);
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
}
