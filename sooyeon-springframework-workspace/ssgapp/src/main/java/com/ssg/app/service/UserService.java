package com.ssg.app.service;

import com.ssg.app.dto.UserDto;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

    int registUser(UserDto user);

    int getUserCount(String checkId);

    UserDto getUser(UserDto user);

    int modifyUserProfile(UserDto loginUser, MultipartFile uploadFile);

}
