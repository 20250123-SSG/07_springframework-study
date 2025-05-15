package com.johnth.ajax.controller;

import com.johnth.ajax.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class AjaxController {
    /*
        ResponseBody
        1. 컨트롤러 메서드의 반환값을 HTTP 본문에 담아 전송하도록 지정하는 애너테이션
        2. 반환값을 뷰 경로가 아닌 클라이언트가 원하는 데이터 형식으로 변환해서 전달해야될때 사용
     */
    @ResponseBody
    @GetMapping(value = "/ajaxTest1.do", produces = "text/html; charset=utf-8")
    public String ajaxTest1(@RequestParam("id") String id, String pwd){
        log.debug("param id : {}, pwd: {}", id, pwd);
        String searchName = "홍길동";
        return searchName;
    }
    /*
    @ResponseBody
    @PostMapping(value= "/ajaxTest2.do", produces = "text/html; charset=utf-8")
    public String ajaxTest2(String id, String pwd){
        log.debug("param id : {}, pwd: {}", id, pwd);
        String searchName = "와우 빡빡이";
        return searchName;
    }

     */
    @ResponseBody
    @PostMapping(value= "/ajaxTest2.do", produces = "text/html; charset=utf-8")
    public String ajaxTest2(UserDto userDto){
        log.debug("userDto: {}", userDto);
        String searchName = "김";
        return searchName;
    }

    @ResponseBody
    @PostMapping(value= "/ajaxTest3.do", produces = "text/html; charset=utf-8")
    public String ajaxTest3(@RequestBody UserDto userDto){
        log.debug("userDto: {}", userDto);
        String searchName = "세번째";
        return searchName;
    }
}
