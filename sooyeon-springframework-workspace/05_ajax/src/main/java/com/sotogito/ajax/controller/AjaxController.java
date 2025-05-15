package com.sotogito.ajax.controller;

import com.sotogito.ajax.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
public class AjaxController {

    /**
     * @ResponseBody
     * 1. 컨트롤러의 메서드의 반환값을 HTTP본문(body)에 담아서 전송하도록 지정하는 어노테이션
     * 2. 즉, 반환하던 뷰경로로 해석하지 않고, 클라이언트가원하는 데이터 형식으로 변환해서 전달해야될 때 사용
     */
    @ResponseBody
    @GetMapping(value = "/ajaxTest1.do", produces = "text/html; charset=utf-8")
    public String ajaxTest1(@RequestParam String id, @RequestParam String pwd) {
        log.debug("param id:{}, pwd:{}", id, pwd);
        String searchedName = "홍길동";

        return searchedName;
    }

    @ResponseBody
    @PostMapping(value = "/ajaxTest2.do", produces = "text/html; charset=utf-8")
    public String ajaxTest2(UserDto user) {
        log.debug("param id:{}, pwd:{}", user.getId(), user.getPwd());
        String searchedName = "홍길동";

        return searchedName;
    }

    @ResponseBody
    @PostMapping(value = "/ajaxTest3.do", produces = "text/html; charset=utf-8")
    public String ajaxTest3(@RequestBody UserDto user) {
        log.debug("param id:{}, pwd:{}", user.getId(), user.getPwd());
        String searchedName = "3";

        return searchedName;
    }

    @ResponseBody
    @GetMapping(value = "/ajaxTest4.do")
    public UserDto ajaxTest4(int no) {
        log.debug("param no:{}", no);
        UserDto searchedUser = new UserDto("test", "pass", "홍길순", 10);

        return searchedUser;
    }

    @ResponseBody
    @GetMapping(value = "/ajaxTest5.do")
    public List<UserDto> ajaxTest5() {
        List<UserDto> selectedUsers = List.of(                              //[
                new UserDto("user1","pass2","1",1),  //{}
                new UserDto("user2","pass3","2",2),
                new UserDto("user3","pass4","3",3),
                new UserDto("user4","pass5","4",4),
                new UserDto("user5","pass6","5",5)
        );
        return selectedUsers;
    }


}
