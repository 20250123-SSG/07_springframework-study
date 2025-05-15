package com.sotogito.webmvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/// "/" url 요청시 /WEB-INF/views/,ain.jsp가 보여지도록 forwarding하기
// 스프링 사용하기 전 : 각 url 요청별 처리할 Servlet 클래스 만들어서 처리

/**
 * 스프링 사용 후
 * 1. 요청 처리를 담당할 controller 클래스를 @controller를 총해 빈으로 등록시키기
 * 2. 각 url 요청별 처리할 내용을 메서드로 작성하기
 * 3. 단, url요청과 실행시킬 메서드를 매핑시며주는 @RequestMapping 어노테이션 기술
 */
@Controller
public class MvcController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    //    @RequestMapping(value = "/", method= RequestMethod.GET)
    @RequestMapping(value = {"/", "/main.do"}, method = RequestMethod.GET)
    public String welcomePage() {

        logger.trace("Welcome page - 디버깅보다 좀 더 상세한 정보 표현");
        logger.debug("debug message - 개발 단계에서 디버깅 용도로 사용");
        logger.info("info message - 정보성 메시지 기록용");
        logger.warn("warn message - 당장 문제는 없지만 향후 시스템 에러의 원인이 될 수 있는 경고성 메시지용");
        logger.error("요청 처리 중 문제가 발생한 상태를 기록할 용도");

        return "main"; //파일을 문자열로 반환, Bean으로 InternalResourceViewResolver등록 필요
    }

    @RequestMapping(value = "/test1")
    public String registerMember() {
        System.out.println("/tes1");
        return "book/regist";
    }

    @RequestMapping(value = "/test2")
    public String deleteMember() {
        System.out.println("/tes2");
        return "notice/list";
    }

}
