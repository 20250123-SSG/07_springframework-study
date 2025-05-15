package com.ssg.app.dao;


import com.ssg.app.dto.UserDto;

public interface UserMapper {
    int insertUser(UserDto userDto);

    int selectUserCountById(String checkId);

    UserDto selectUserById(String userId);

    int updateProfileImg(UserDto userDto);
}