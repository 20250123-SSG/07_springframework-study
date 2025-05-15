package com.sotogito.sbatis.service;

import com.sotogito.sbatis.dao.MenuMapper;
import com.sotogito.sbatis.dto.MenuDto;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
    public MenuDto getMenuByMenuCode(int menuCode) {
        return sqlSession.getMapper(MenuMapper.class).selectMenuByMenuCode(menuCode);
    }

    @Override
    public int registerMenu(MenuDto menuDto) {
        try {
            return sqlSession.getMapper(MenuMapper.class).insertMenu(menuDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int modifyMenu(MenuDto menuDto) {
        return sqlSession.getMapper(MenuMapper.class).updateMenu(menuDto);
    }

    @Override
    public int removeMenuByMenuCode(String[] menuCodes) {
        try {
            return sqlSession.getMapper(MenuMapper.class).deleteMenusByMenuCode(menuCodes);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("주문된 상품으로 삭제할 수 없습니다");
        }
    }


    //트렌젝션 테스트(두개의 메뉴 일괄 등록) - 둘 중에 하나의 메뉴 등록시 실패되면 rollback)
//    @Override
//    public int registerTwoMenu() {
//        // 테스트용 메뉴 2개 세팅
//        MenuDto menu1 = MenuDto.builder()  //insert 성공 데이터
//                               .menuName("트렌젝션테스트1")
//                               .menuPrice(1000)
//                               .categoryCode(4)
//                               .orderableStatus("Y")
//                               .build();
//        MenuDto menu2 = new MenuDto();  //insert 실패 데이터 -> Column 'menu_name' cannot be null
//
//        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class); //하나의 트랜잭션이기 때문에 같은 mapper사용
//
//        int result1 = menuMapper.insertMenu(menu1);
//        int result2 = menuMapper.insertMenu(menu2);
//
//        return result1 * result2;
//        /**
//         * mybatis-spring에서는 기본적으로 각 쿼리실행때마다 새로운 트랜잭션을 만들어,
//         * 각 트랜젝션으로 관리함. 별도의 예외가 발생되지 않으면 commit을 진행시킴
//         */
//    }

    /**
     *      트랜잭션 방법1 : 선언전 트랜잭션 어노테이션 @Transaction
     */
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public int registerTwoMenu() {
//        MenuDto menu1 = MenuDto.builder()
//                               .menuName("선언전트랜잭션테스트용")
//                               .menuPrice(1000)
//                               .categoryCode(5)
//                               .orderableStatus("Y")
//                               .build();
//        MenuDto menu2 = new MenuDto();
//
//        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class); ///같은 sqlSession을 공유
//
//        int result1 = menuMapper.insertMenu(menu1); ///최초 트랜잭션 생성
//        int result2 = menuMapper.insertMenu(menu2); /// 최초 트랜잭션 재사용 //예외가 터지는 부분 RuntimeException -> rollback
//
//        return result1 * result2;
//    }


    /**
     *      트랜잭션 방법2 : AOP Advice 등록
     */
    @Override
    public int registerTwoMenu() {
        MenuDto menu1 = MenuDto.builder()
                .menuName("AOP Advice 트랜잭션테스트용")
                .menuPrice(1000)
                .categoryCode(5)
                .orderableStatus("Y")
                .build();
        MenuDto menu2 = new MenuDto();

        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class); ///같은 sqlSession을 공유

        int result1 = menuMapper.insertMenu(menu1); ///최초 트랜잭션 생성
        int result2 = menuMapper.insertMenu(menu2); /// 최초 트랜잭션 재사용 //예외가 터지는 부분 RuntimeException -> rollback

        return result1 * result2;
    }

}
