package com.ksh.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@RequestMapping("/book")
@Controller
public class BookController {
/*
    @RequestMapping(value = "/book/list.do" ,method = RequestMethod.GET)
    public String bookList(){
        System.out.println("포워딩book");
        return "book/list";
    }

    @RequestMapping(value = "/book/detail.do" , method = RequestMethod.GET)
    public String bookDetail(){
        return "book/detail";
    }

    @RequestMapping(value = "/book/modifyForm.do" , method = RequestMethod.GET)
    public String bookModify(){
        return "book/modify";
    }

 */
//@RequestMapping(value = "/list.do" ,method = RequestMethod.GET)
    @GetMapping(value = "/list.do")
public String bookList(){
    System.out.println("포워딩book");
    return "book/list";
}

    @RequestMapping(value = "/detail.do" , method = RequestMethod.GET)
    public String bookDetail(){
        return "book/detail";
    }

    @GetMapping("modifyForm.do")
    public String bookModifyForm(){
        return "book/modify";
    }
    @PostMapping("/modify.do")
    public String bookModify(){
        System.out.println("url재요청");
        return "redirect:/book/detail.do?no=x";
    }

}
