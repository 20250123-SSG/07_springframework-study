package com.ssg.app.service;

import com.ssg.app.dao.UserMapper;
import com.ssg.app.dto.UserDto;
import com.ssg.app.util.FileUtil;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final SqlSessionTemplate sqlSession;
    private final FileUtil fileUtil;

    @Override
    public int registUser(UserDto user) {
        return sqlSession.getMapper(UserMapper.class).insertUser(user);
    }

    @Override
    public int checkUser(String checkId) {
        return sqlSession.getMapper(UserMapper.class).selectUserCountById(checkId);
    }

    @Override
    public UserDto getUser(UserDto user) {
        return sqlSession.getMapper(UserMapper.class).selectUserById(user.getUserId());
    }

    @Override
    public int modifyUserProfile(UserDto loginUser, MultipartFile uploadFile) {
        Map<String, String> map = fileUtil.fileupload("profile", uploadFile);
        loginUser.setProfileURL(map.get("filePath") + "/" + map.get("filesystemName"));
        int result = sqlSession.getMapper(UserMapper.class).updateProfileImg(loginUser);
        return result;
    }
}
