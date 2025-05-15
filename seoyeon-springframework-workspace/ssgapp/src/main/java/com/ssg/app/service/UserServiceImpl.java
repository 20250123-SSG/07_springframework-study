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
    public int getUserCount(String  checkId){
        return sqlSession.getMapper(UserMapper.class).selectUserCountById(checkId);
    }

    @Override
    public UserDto getUser(UserDto user){

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserDto selectedUser = userMapper.selectUserById(user.getUserId());

        //로그인 실패 케이스
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
    public void modifyUserProfile(UserDto loginUser, MultipartFile uploadFile){

        Map<String, String> map = fileUtil.fileupload("profile", uploadFile);
        loginUser.setProfileURL(map.get("filePath") + "/" + map.get("filesystemName"));
        // "/upload/profile/20250515/123ahfue14h2iuha124.jpg"
        return sqlSession.getMapper(UserMapper.class).updateProfileImg(loginUser);
    }
}
