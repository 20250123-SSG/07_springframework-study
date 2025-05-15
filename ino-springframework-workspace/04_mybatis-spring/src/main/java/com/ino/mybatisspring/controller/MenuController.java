package com.ino.mybatisspring.controller;

import com.ino.mybatisspring.dto.MenuDto;
import com.ino.mybatisspring.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/menu")
@RequiredArgsConstructor
@Controller
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/list.page")
    public void menuListPage(Model model){
        model.addAttribute("list", menuService.getAllMenu());
    }

    @GetMapping("/regist.page")
    public void menuRegistPage(){}

    @PostMapping("/regist.do")
    public String registMenu(MenuDto menu, RedirectAttributes ra){
        int result = menuService.insertMenu(menu);
        String message;
        if(result > 0){
            message = menu.getMenuCode() + "Success";
        }else{
            message = "Failed";
        }
        ra.addFlashAttribute("message", message);
        return "redirect:/menu/list.page";
    }

    @GetMapping("/detail.page")
    public void detailMenu(int code, Model model){
        model.addAttribute("menu",  menuService.getMenuByCode(code));
    }

    @GetMapping("/modify.page")
    public void modMenu(int code, Model model){
        model.addAttribute("menu",  menuService.getMenuByCode(code));
    }

    @PostMapping("/modify.do")
    public String modMenu(MenuDto menu, RedirectAttributes ra){
        int result = menuService.updateMenu(menu);
        String message;
        if(result>0){
            message = "Successed";
        }else {
            message = "failed";
        }
        ra.addFlashAttribute("message", message);
        return "redirect:/menu/detail.page?code="+menu.getMenuCode();
    }

    @PostMapping("/remove.do")
    public String deleteMenus(String[] code, RedirectAttributes ra){
        System.out.println(code);
        int result = menuService.deleteMenu(code);
        String message;
        if(result == code.length){
            message = "Successed, " + result + " deleted";
        }else {
            message = "failed";
        }
        ra.addFlashAttribute("message", message);
        return "redirect:/menu/list.page";
    }

    @GetMapping("/transaction.do")
    public void transactionTest(){
        menuService.registTwoMenu();
    }
}
