package com.younggalee.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    //  @GetMapping은 DispatcherServlet의 기능 그 자체는 아니고, DispatcherServlet이 요청을 적절한 메서드로 연결할 때 참고하는 정보
    //  @GetMapping  HTTP GET 요청처리   페이지 조회, 데이터 조회
    //  @PostMapping  HTTP POST 요청처리    폼 전송, 데이터 생성/등록


    @GetMapping("/")
    public String mainPage(){
        return "main"; // /WEB-INF/views/main.jsp 경로의 페이지로 포워딩(페이지를 응답데이터로 돌려주는 것)
    }
}
