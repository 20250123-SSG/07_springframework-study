package com.inyong.sbatis.service;

import com.inyong.sbatis.dao.MenuMapper;
import com.inyong.sbatis.dto.MenuDto;
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
        return null;
    }

    @Override
    public int registMenu(MenuDto menu) {
        return 0;
    }

    @Override
    public int modifyMenu(MenuDto menu) {
        return 0;
    }

    @Override
    public int removeMenu(String[] codes) {
        return 0;
    }
}
