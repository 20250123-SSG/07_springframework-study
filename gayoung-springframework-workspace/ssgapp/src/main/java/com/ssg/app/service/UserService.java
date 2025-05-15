package com.ssg.app.service;

import com.ssg.app.dto.UserDto;

public interface UserService {
    //회원등록
    int registUser(UserDto user);

    // 중복체크를 위해 db상에 몇명 존재하는지 count값
    int getUserCount(String checkId);

    UserDto getUser(UserDto user);
}
