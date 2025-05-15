package com.ssg.app.dao;

import com.ssg.app.dto.UserDto;

public interface UserMapper {

    int insertUser(UserDto user);
    int selectUserCountById(String checkId);
    UserDto selectUserById(String userId);
}
