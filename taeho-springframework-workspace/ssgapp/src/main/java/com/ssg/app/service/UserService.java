package com.ssg.app.service;

import com.ssg.app.dto.UserDto;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    int registUser(UserDto userDto);
    int checkUser(String checkId);
    UserDto getUser(UserDto userDto);
    int modifyUserProfile(UserDto loginUser, MultipartFile uploadFile);
}