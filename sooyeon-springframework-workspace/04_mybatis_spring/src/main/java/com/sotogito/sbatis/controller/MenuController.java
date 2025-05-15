package com.sotogito.sbatis.controller;


import com.sotogito.sbatis.dto.MenuDto;
import com.sotogito.sbatis.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RequiredArgsConstructor
@RequestMapping("/menu")
@Controller
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/list.page")
    public String menuListPage(Model model) {
        model.addAttribute("menuList", menuService.getMenuAll());

        return "menu/list";
    }

    @GetMapping("/regist.page")
    public String menuRegistPage() {
        return "menu/regist";
    }

    @PostMapping("/regist.do")
    public String menuRegist(@ModelAttribute MenuDto menu, RedirectAttributes redirectAttributes) {
        int insertResult = menuService.registerMenu(menu);

        String message = "";
        if (insertResult > 0) {
            message = menu.getMenuCode() + "번 등록 성공";
        } else {
            message = "실패";
        }

        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/menu/list.page";
    }

    @GetMapping("/detail.page")
    /// /menu/detail.page?menuCode=${menu.menuCode}
    public String menuDetailPage(@RequestParam int menuCode, Model model) {
        MenuDto menu = menuService.getMenuByMenuCode(menuCode);
        model.addAttribute("menu", menu);

        return "menu/detail";
    }

    @GetMapping("/modify.page")
    /// /menu/modify.page?menuCode=${menu.menuCode}
    public String menuModifyPage(@RequestParam int menuCode, Model model) {
        MenuDto menu = menuService.getMenuByMenuCode(menuCode);
        model.addAttribute("menu", menu);

        return "menu/modify";
    }

    @PostMapping("/modify.do")
    public String modifyMenu(@ModelAttribute MenuDto menu, RedirectAttributes redirectAttributes) {
        int modifyResult = menuService.modifyMenu(menu);

        String message = "";
        if (modifyResult > 0) {
            message = "성공";
        } else {
            message = "실패";
        }
        redirectAttributes.addFlashAttribute("message", message);

        return "redirect:/menu/detail.page?menuCode=" + menu.getMenuCode();
    }

    @PostMapping("/remove.do")
    /// /menu/remove.do?code=X$code=x
    public String removeMenu(@RequestParam String[] code, RedirectAttributes redirectAttributes) {
        int removeResult = 0;
        String message = "";

        try {
            removeResult = menuService.removeMenuByMenuCode(code);
        } catch (DataIntegrityViolationException e) {
            message = e.getMessage();
        }
        if (removeResult == code.length) {
            message = "성공";
        }
        redirectAttributes.addFlashAttribute("message", message);

        return "redirect:/menu/list.page";
    }


    @GetMapping("/transaction.do")
    public void transactionTest() {
        menuService.registerTwoMenu();
    }
}
