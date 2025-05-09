package com.ibe6.webmvc.controller;


// "/" url 요청시 /WEB-INF/views/main.jsp 가 보여지도록 forwarding 하기

// * 스프링 사용전 : 각 url 요청별 처리할 Servlet 클래스 만들어서 처리
/*
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/")
public class MvcController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1) 포워딩하고자 할 경우
        request.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(request, response);

        // 2) 리다이렉트 하고자 할 경우
        response.sendRedirect("/xxxx");
    }

}
*/


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// * 스프링 사용후
//   1) 요청 처리를 담당할 Controller 클래스를 @Controller 통해 빈으로 등록시키기
//   2) 각 url 요청별 처리할 내용을 메소드로 작성하기
//   3) 단, url 요청과 실행시킬 메소드를 매핑 시켜주는 @RequestMapping 어노테이션 기술
@Controller
public class MvcController {

    // "/" 또는 "/main.do" 요청시 해당 메소드가 실행되도록

    //@RequestMapping(value="/", method= RequestMethod.GET)
    @RequestMapping(value={"/", "/main.do"}, method=RequestMethod.GET)
    public String welcomePage(){
        System.out.println("MvcController 클래스의 welcomePage 메소드 실행");
        //return "/WEB-INF/views/main.jsp";
        return "main";
    }

    @RequestMapping(value="/test1")
    public String registMember(){
        System.out.println("/test1에 의해서 메소드 동작");
        //return "/WEB-INF/views/book/regist.jsp";
        return "book/regist";
    }

    @RequestMapping(value="/test2")
    public String deleteMember(){
        System.out.println("/test2에 의해서 메소드 동작");
        //return "/WEB-INF/views/notice/list.jsp";
        return "notice/list";
    }

}




