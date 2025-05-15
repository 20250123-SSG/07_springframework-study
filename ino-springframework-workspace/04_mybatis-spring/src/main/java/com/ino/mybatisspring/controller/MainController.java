package com.ino.mybatisspring.controller;

import com.ino.mybatisspring.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @GetMapping(value = {"/", "main.page"})
    public String mainPage(){
        return "main";
    }
}
