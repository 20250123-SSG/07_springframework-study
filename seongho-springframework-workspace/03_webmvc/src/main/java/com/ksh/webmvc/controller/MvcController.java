package com.ksh.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// "/" 요청시 main.jsp가 보여지도록
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//
//public class MvcController extends HttpServlet {
//
//    public void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
//        request.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(request,response);
//
//    }
//}
//spring 사용
@Controller
public class MvcController{
    @RequestMapping(value = "/" ,method = RequestMethod.GET)
    public String welcomePage(){
        System.out.println("welcomePage실행");
        return "main";
    }
    public void registMember(){

    }


}