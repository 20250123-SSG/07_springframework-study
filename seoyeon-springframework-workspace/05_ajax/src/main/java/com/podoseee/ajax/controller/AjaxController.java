package com.podoseee.ajax.controller;

import com.podoseee.ajax.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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
        String searchedName = "조규현"; // 조회된 회원의 이름을 응답데이터로 돌려주기
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
        String searchedName = "윤소희";
        return searchedName;
    }

    // Jackson 라이브러리 : JSON문자열 <===자동변환===> Java객체

    @ResponseBody
    @PostMapping(value="/ajaxTest3.do", produces="text/html; charset=utf-8") // "{'id':'xxx', 'pwd':'xxx'}"
    public String ajaxTest3(@RequestBody UserDto user){
        log.debug("user: {}", user);
        String searchedName = "정현규";
        return searchedName;
    }

    @GetMapping(value="/ajaxTest4.do", produces="application/json")
    public UserDto ajaxTest4(int no){
        log.debug("param no: {}", no);
        UserDto searchedUser = new UserDto("test01", "pass01", "이세돌", 40);
        return searchedUser;
        // Java객체 => JSON문자열 '{"id":"test01", "pwd":"pass01", "name":"이세돌", "age":40}'
        // Java객체(배열) =>JSON문자열 '["파랑", "빨강", "초록"]
        // Java객체(Map)  => {}
        // Java객체(List) => []
    }

    @ResponseBody
    @GetMapping(value="/ajaxTest5.do", produces = "application/json")
    public List<UserDto> ajaxTest5(){
        List<UserDto> selectedUsers = List.of(                                      // [
                new UserDto("user01", "pass01", "이마크", 27), //    {id1 : },
                new UserDto("user02", "pass02", "이해찬", 26), //    {id2 : },
                new UserDto("user03", "pass03", "나재민", 25), //    {id3 : },
                new UserDto("user04", "pass04", "박지성", 24)  //    {id4 : }
                                                                                    // ]
        );
        return selectedUsers;
    }
}
