package com.younggalee.ajax.controller;

import com.younggalee.ajax.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
public class AjaxController {

    /*
        ## @ResponseBody ##
        1. 컨트롤러 메소드의 반환값을 HTTP 본문(body)에 담아서 전송하도록 지정하는 어노테이션
        2. 즉, 반환값을 뷰경로로 해석하지 않고, 클라이언트가 원하는 데이터 형식으로 변환해서 전달해야될 때 사용
     */
    @ResponseBody
    @GetMapping(value="/ajaxTest1.do", produces="text/html; charset=utf-8")
    public String ajaxTest1(String id, String pwd){
        log.debug("param id: {}, pwd: {}", id, pwd);
        String searchedName = "홍길동"; // 조회된 회원의 이름을 응답데이터로 돌려주기
        return searchedName;
    }

    /*
    @ResponseBody
    @PostMapping(value="/ajaxTest2.do", produces="text/html; charset=utf-8")
    public String ajaxTest2(String id, String pwd){
        log.debug("param id: {}, pwd: {}", id, pwd);
        String searchedName = "강개순";
        return searchedName;
    }
     */

    @ResponseBody
    @PostMapping(value="/ajaxTest2.do", produces="text/html; charset=utf-8")
    public String ajaxTest2(UserDto user){
        log.debug("user: {}", user);
        String searchedName = "강개순";
        return searchedName;
    }

    // Jackson 라이브러리 : JSON문자열 <===자동변환===> Java객체

    @ResponseBody
    @PostMapping(value="/ajaxTest3.do", produces="text/html; charset=utf-8") // "{'id':'xxx', 'pwd':'xxx'}"
    public String ajaxTest3(@RequestBody UserDto user){
        log.debug("user: {}", user);
        String searchedName = "김말똥";
        return searchedName;
    }

    @GetMapping(value = "/ajaxTest4.do")
    public UserDto ajaxTest4(int no){
        log.debug("param no: {}", no);
        UserDto searchedUser = new UserDto("test1", "pass01", "홍길순",10); // 이걸 현재머물고 있는 페이지로 응답결과 돌려줌
        return searchedUser; //객체는 이런 식으로 전송불가 > 자바스크립트에서 객체형식으로 보내야한다.
        // '{}'  JSON문자열로 객체변경
    }

    @ResponseBody
    @GetMapping(value = "/ajaxTest5.do")
    public List<UserDto> ajaxTest5(){
        List<UserDto> selectedUsers = List.of(
                new UserDto("user1", "pass1", "홍길동", 10),
                new UserDto("user2", "pass2", "홍길동2", 10)
        );
        return selectedUsers;
    }

}