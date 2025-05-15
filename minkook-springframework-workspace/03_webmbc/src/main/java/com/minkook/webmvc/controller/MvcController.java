package com.minkook.webmvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

//@WebServlet("/")
//public class MvcController {
////    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
////        //1) 포워딩하고자 할 경우
////        request.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(request,response);
////
////        //2) 리다이렉트 하고자 할 경우
////        response.sendRedirect("/xxxx");
////    }
//
//
//
//}
// * 스프링 사용후
// 1) 요청 처리를 담당할 Controller 클래스를 @Controleer 통해 빈으로 등록시키기
// 2) 각 URl 요청별 처리할 내용을 메소드로 작성하기
// 3) 단, URl 요청과 실행시킬 메소드를 매핑 시켜주는 @RequestMapping 어노테이션 기술
@Controller
public class MvcController {
    @RequestMapping(value =  "/",method = RequestMethod.GET)
    public void welcomPage(){
        System.out.println("MvcController 클래스의 welcompage 호출");
    }
    @RequestMapping(value = "/test1")
    public void registMember(){
        System.out.println("MvcController 클래스의 registMember 호출");
    }
    @RequestMapping(value = "/test2")
    public void deleteMember(){
        System.out.println("MvcController 클래스의 deleteMember 호출");
    }
}