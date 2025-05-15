package com.inyong.sbatis.controller;

import com.inyong.sbatis.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/menu")
@Controller
public class MenuCotroller {

    private final MenuService menuService;

    @GetMapping("/list.page")
    public void menuListPage(Model model){
        model.addAttribute("list", menuService.getMenuAll());
    }

}
