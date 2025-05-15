package com.kyungbae.webmvc.controller;


// "/" url 요청시 /WEB-INF/views/main.jsp 가 보여지도록 forwarding 하기

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 1. 요청 처리를 담당할 Controller 클래스를 @Controller 통해 Bean 으로 등록시키기
// 2. 각 url 요청별 처리할 내용을 메소드로 작성하기
// 3. url 요청과 실행시킬 메소드를 매핑 시켜주는 @RequestMapping 어노테이션 기술
@Controller
public class MvcController {

    private Logger logger = LoggerFactory.getLogger(MvcController.class);

    @RequestMapping(value = {"/", "/main", "/main.do"}, method = RequestMethod.GET)
    public String welcomePage(){
        // System.out.println("mc-welcomePage");

//        logger.trace("trace message - 가장 상세한 정보");
//        logger.debug("debug message - 개발단계 디버깅 용도");
//        logger.info("info message - 정보성 메세지");
//        logger.warn("warn message - 당장엔 문제가 없지만 시스템 에러의 원인이 될 수 있는 경고");
//        logger.error("error message - 요청 처리 중 문제가 발생한 상태를 기록할 용도");

        return "main";
    }

    @RequestMapping(value = "/test1")
    public String registMember(){
        System.out.println("mc-registMember");
        return "book/regist";
    }

    @RequestMapping(value = "/test2")
    public String deleteMember() {
        System.out.println("mc-deleteMember");
        return "notice/list";
    }

}
