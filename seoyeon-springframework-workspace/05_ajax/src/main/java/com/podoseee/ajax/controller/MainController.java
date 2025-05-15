package com.podoseee.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String mainPage() {
        return "main";  //  /WEB-INF/views/main.jsp  경로의 페이지로 포워딩(페이지를 응답데이터로 돌려주는 것)
    }
}
