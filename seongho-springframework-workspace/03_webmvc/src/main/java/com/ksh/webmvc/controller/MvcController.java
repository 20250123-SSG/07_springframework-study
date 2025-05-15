package com.ksh.webmvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(MvcController.class);

    @RequestMapping(value = {"/","/main.do" },method = RequestMethod.GET)
    public String welcomePage(){
        //System.out.println("welcomePage실행");
        /*
        logger.trace("디버깅보다 상세한정보");
        logger.debug("개발 단계에서 디버깅 용도");
        logger.info("정보성 메세지 기록");
        logger.warn("당장 문제는 없지만 향후 시스템 에러의 원인이 될 수 있는 경고성");
        logger.error("요청처리중 문제");
         */

        return "main";
    }
    public void registMember(){

    }


}