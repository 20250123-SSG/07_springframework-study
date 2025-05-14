package com.ibe6.ajax2.controller;
import com.ibe6.ajax2.dto.UserDto;
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

    @ResponseBody
    @GetMapping(value = "/ajaxTest4.do", produces = "application/json")
    public UserDto ajaxTest4(int no){
        log.debug("param no: {}", no);
        UserDto searchedUser = new UserDto("test01", "pass01", "홍길순", 10);
        return searchedUser;
        // Java객체(DTO) => JSON문자열 '{"id":"test01", "pwd":"pass01", "name":"홍길순", "age":10}'
        // Java객체(배열) => JSON문자열 '["파랑","빨강","초록"]'
        // Java객체(Map)  => {}
        // Java객체(List) => []
    }

    @ResponseBody
    @GetMapping(value = "/ajaxTest5.do", produces = "application/json")
    public List<UserDto> ajaxTest5(){
        List<UserDto> selectedUsers = List.of(                  // [
                new UserDto("user01", "pass01", "홍길순", 10),  // {'id':'user01', ..},
                new UserDto("user02", "pass02", "홍길동", 20),  // {'id':'user01', ..},
                new UserDto("user03", "pass03", "홍길남", 30),  // {'id':'user01', ..},
                new UserDto("user04", "pass04", "홍길정", 40)   // {'id':'user01', ..}
        );                                                      // ]
        return selectedUsers;
    }

}