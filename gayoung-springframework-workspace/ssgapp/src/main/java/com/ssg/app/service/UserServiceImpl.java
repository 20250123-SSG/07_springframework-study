package com.ssg.app.service;

import com.ssg.app.dao.UserMapper;
import com.ssg.app.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final SqlSessionTemplate sqlSession;//생성자 객체 주입받으려고 final + @requiredA~

    @Override
    public int registUser(UserDto user) {

        return sqlSession.getMapper(UserMapper.class).insertUser(user); //컨트롤러에서 받은 객체바로 넘김
    }

    @Override
    public int getUserCount(String checkId) {
        return sqlSession.getMapper(UserMapper.class).selectUserCountById(checkId); //컨트롤러에서 받은 객체바로 넘김
    }

    @Override
    public UserDto getUser(UserDto user) {
        // 아이디, 비번 가지고 유저정보 다 가져오기
        UserDto selectedUser = sqlSession.getMapper(UserMapper.class).selectUserById(user.getUserId());

        // 로그인 실패일 경우에는
        if (selectedUser == null || !user.getUserPwd().equals(selectedUser.getUserPwd())) { // 조회실패 또는 비번이 틀렸을 경우
            return null;
        }
        return selectedUser;
    }


}
