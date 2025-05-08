package com.ino.webmvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

//@WebServlet("/")
//public class MvcController extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // forwarding
//        req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);
//
//        //redirect
//
//        resp.sendRedirect("");
//    }
//}

@Controller
public class MvcController {
    @RequestMapping(value = {"/", "/main.do"}, method = RequestMethod.GET)
    public String welcomePage(){
        System.out.println("MvcController Class welcomePage Method");
        return "main";
    }

    @RequestMapping(value = "/test1")
    public String registMember(){
        System.out.println("test1");
        return "/book/regist";
    }

    @RequestMapping(value = "/test2")
    public String deleteMember(){
        System.out.println("test2");
        return "/notice/list";
    }
}