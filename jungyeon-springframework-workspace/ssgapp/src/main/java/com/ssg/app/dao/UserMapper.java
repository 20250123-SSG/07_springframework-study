package com.ssg.app.dao;

import com.ssg.app.dto.UserDto;
import org.springframework.web.multipart.MultipartFile;

public interface UserMapper {

    int insertUser(UserDto user);
    int selectUserCountById(String checkId);
    UserDto selectUserById(String userId);
    int updateProfileImg(UserDto user);
}
