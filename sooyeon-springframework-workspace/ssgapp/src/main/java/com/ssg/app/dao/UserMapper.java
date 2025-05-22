package com.ssg.app.dao;

import com.ssg.app.dto.UserDto;

public interface UserMapper {

    UserDto selectUserById(String userId);

    int selectUserCountById(String checkId);

    int insertUser(UserDto user);

    int updateProfileImg(UserDto user);

}
