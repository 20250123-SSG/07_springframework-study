package com.johnth.webmvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
// 스프링 사용전 (포워딩 여부에 따른 아래 방법들 중 하나를 사용)
public class MVCController extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 방법 1)forwarding
        req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);

        // 방법 2)redirect
        resp.sendRedirect("/");
    }

}
*/


/* 스프링 사용
    1) 요청 처리를 담당할 Controller 클래스를 @Controller 애너테이션을 사용해 빈으로 등록
    2) 각 url 요청별 처리할 내용을 메서드로 작성
    3) @RequestMapping를 사용해서 url요청과 실행시킬 매서드를 매핑
 */
@Controller
public class MVCController {

    private Logger logger = LoggerFactory.getLogger(MVCController.class);

    @RequestMapping(value = {"/", "/main.do"}, method = RequestMethod.GET)
    public String mainPage(){
        System.out.println("MVCController mainPage() 실행");

        logger.trace("trace message - 디버깅보다는 상세한 정보");
        logger.debug("debug message - 개발단계 디버깅용도");
        logger.info("info message - 정보성 메시지");
        logger.warn("warn message - 당장 문제는 없지만 추후 시스템 에러의 원인이 될 수 있는 경보성 메시지");
        logger.error("error message - 요청 처리중 문제가 발생한 상태를 기록");

        return "main";
    }

    @RequestMapping(value="/test1")
    public String registMember(){
        System.out.println("/test1 메서드 실행");
        return "book/regist";
    }

    @RequestMapping(value="/test2")
    public String deleteMember(){
        System.out.println("/test2 메서드 실행");
        return "notice/list";
    }

}