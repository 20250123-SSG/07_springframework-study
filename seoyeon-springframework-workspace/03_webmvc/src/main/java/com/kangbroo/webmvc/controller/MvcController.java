package com.kangbroo.webmvc.controller;

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


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(MvcController.class);

    //@RequestMapping(value="/", method= RequestMethod.GET)
    @RequestMapping(value={"/", "/main.do"}, method=RequestMethod.GET)
    public String welcomePage(){
        //System.out.println("MvcController 클래스의 welcomePage 메소드 실행");
        //return "/WEB-INF/views/main.jsp";

        /*
        logger.trace("trace message - 디버깅보다 상세한 정보 표현");
        logger.debug("debug message - 개발 단계에서 디버깅 용도로 사용");
        logger.info("info message - 정보성 메세지 기록용");
        logger.warn("warn message - 당장 문제는 없지만 향후 시스템 에러의 원인이 될 수 있는 경고성 메세지용");
        logger.error("error message - 요청 처리 중 문제가 발생한 상태를 기록할 용도");
        */

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












