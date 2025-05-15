package com.ksh.sbatis.service;

import com.ksh.sbatis.dao.MenuMapper;
import com.ksh.sbatis.dto.MenuDto;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
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

    /*
    //트랜잭션 테스트 ( 두개의 메뉴 일괄 등록 둘중에 하나의 메뉴 등록시 실패되면 rollback
    @Override
    public int registTwoMenu() {

        //테스트 메누 2개 세팅
        MenuDto menu1 = MenuDto.builder()
                .menuName("트랜잭션 테스트용 ㅋ")
                .menuPrice(1000)
                .categoryCode(4)
                .orderableStatus("Y")
                .build();
        MenuDto menu2 = new MenuDto();

        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result1 =menuMapper.insertMenu(menu1);
        int result2 = menuMapper.insertMenu(menu2);

        return result1*result2;
    }     */
    //트랜잭션 처리 첫번째 선언적 트랜잭션 방버업 @Transactional
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public int registTwoMenu() {
//
//        //테스트 메누 2개 세팅
//        MenuDto menu1 = MenuDto.builder()
//                .menuName("선언적 트랜잭션 테스트용 ㅋ")
//                .menuPrice(2000)
//                .categoryCode(5)
//                .orderableStatus("N")
//                .build();
//        MenuDto menu2 = new MenuDto();
//
//        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
//        int result1 =menuMapper.insertMenu(menu1);
//        int result2 = menuMapper.insertMenu(menu2);
//
//        return result1*result2;
//    }
    //트랜잭션 처리방법2 aop
    @Override
    public int registTwoMenu() {

        //테스트 메누 2개 세팅
        MenuDto menu1 = MenuDto.builder()
                .menuName("aop 트랜잭션 테스트용 ㅋ")
                .menuPrice(2000)
                .categoryCode(5)
                .orderableStatus("N")
                .build();
        MenuDto menu2 = new MenuDto();

        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result1 =menuMapper.insertMenu(menu1);
        int result2 = menuMapper.insertMenu(menu2);

        return result1*result2;
    }
}