package com.ino.mybatisspring.service;

import com.ino.mybatisspring.dao.MenuMapper;
import com.ino.mybatisspring.dto.MenuDto;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public int registTwoMenu() {

        MenuDto m1 = new MenuDto().builder().menuName("menu1").menuPrice(2500).categoryCode(2).orderableStatus("Y").build();
        MenuDto m2 = new MenuDto().builder().menuName("menu2").menuPrice(2500).categoryCode(2).orderableStatus("YY").build();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        int r1 = menuMapper.insertMenu(m1);
        int r2 = menuMapper.insertMenu(m2);
        return r1 + r2;
    }

//    @Transactional(rollbackFor = Exception.class)
//    @Override
//    public int registTwoMenu() {
//
//        MenuDto m1 = new MenuDto().builder().menuName("menu1").menuPrice(2500).categoryCode(2).orderableStatus("Y").build();
//        MenuDto m2 = new MenuDto().builder().menuName("menu2").menuPrice(2500).categoryCode(2).orderableStatus("YY").build();
//        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
//        int r1 = menuMapper.insertMenu(m1);
//        int r2 = menuMapper.insertMenu(m2);
//        return r1 + r2;
//    }
}
