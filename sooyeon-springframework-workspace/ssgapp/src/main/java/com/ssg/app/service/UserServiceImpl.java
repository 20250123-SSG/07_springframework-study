package com.ssg.app.service;

import com.ssg.app.dao.UserMapper;
import com.ssg.app.dto.UserDto;
import com.ssg.app.util.FileUtil;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final SqlSessionTemplate sqlSession;
    private final FileUtil fileUtil;

    @Override
    public int registUser(UserDto user) {
        return sqlSession.getMapper(UserMapper.class).insertUser(user);
    }

    @Override
    public int getUserCount(String checkId) {
        return sqlSession.getMapper(UserMapper.class).selectUserCountById(checkId);
    }

    @Override
    public UserDto getUser(UserDto user) {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserDto selectedUser = userMapper.selectUserById(user.getUserId());

        if(selectedUser == null) {
            return null;
        }

        boolean isValidPwd = user.getUserPwd().equals(selectedUser.getUserPwd());
        if(!isValidPwd) {
            return null;
        }

        return selectedUser;

    }

    @Override
    public int modifyUserProfile(UserDto loginUser, MultipartFile uploadFile) {
        Map<String, String> imgUploadResult = fileUtil.fileupload("profile", uploadFile);
        String profileURL = imgUploadResult.get("filePath") + "/" + imgUploadResult.get("filesystemName");

        loginUser.setProfileURL(profileURL);

        return sqlSession.getMapper(UserMapper.class).updateProfileImg(loginUser); //아그러네 매퍼 마지막에 생성해도되구나
    }

}
