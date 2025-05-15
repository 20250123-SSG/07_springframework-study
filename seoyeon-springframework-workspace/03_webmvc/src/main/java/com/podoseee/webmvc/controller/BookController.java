package com.podoseee.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {

    /*
    @RequestMapping(value="/book/list.do", method= RequestMethod.GET)
    public String bookList(){
        System.out.println("/WEB-INF/views/book/list.jsp로 포워딩");
        return "book/list"; // 포워딩할 뷰 경로 반환
    }

    // 만일 포워딩한 뷰의 경로가 url 매핑값의 경로와 일치할 경우 void 메소드로 해도 됨
    @RequestMapping(value="/book/detail.do", method=RequestMethod.GET)
    public String bookDetail(){
        System.out.println("/WEB-INF/views/book/detail.jsp로 포워딩");
        return "book/detail";
    }

    @RequestMapping(value="/book/modifyForm.do", method=RequestMethod.GET)
    public String bookModifyForm(){
        System.out.println("/WEB-INF/views/book/modify.jsp로 포워딩");
        return "book/modify";
    }
     */

    //@RequestMapping(value="/list.do", method= RequestMethod.GET)
    @GetMapping(value="/list.do")
    public String bookList(){
        System.out.println("/WEB-INF/views/book/list.jsp로 포워딩");
        return "book/list"; // 포워딩할 뷰 경로 반환
    }

    // 만일 포워딩한 뷰의 경로가 url 매핑값의 경로와 일치할 경우 void 메소드로 해도 됨
    @GetMapping("/detail.do")
    public String bookDetail(){
        System.out.println("/WEB-INF/views/book/detail.jsp로 포워딩");
        return "book/detail";
    }

    @GetMapping("/modifyForm.do")
    public String bookModifyForm(){
        System.out.println("/WEB-INF/views/book/modify.jsp로 포워딩");
        return "book/modify";
    }

    @PatchMapping("/modify.do")
    public String bookModify(){
        System.out.println("/book/detail.do로 url 재요청(redirect)");
        return "redirect:/book/detail.do?no=x";
    }

    /*
    1. 도서목록페이지(book/list.jsp) 에서 "도서등록페이지로이동" 버튼 추가
    2. 해당 버튼 클릭시 "/book/registForm.do" url 요청되도록 설정
        => 도서등록페이지(/WEB-INF/views/book/regist.jsp) 만들어서 띄우기 (폼요소작업)
    3. 도서 등록 페이지에서 "등록" submit 하는 순간
            "/book/regist.do" url 요청되도록 설정
                    => 도서목록페이지가 다시 보여지도록 작업
 */

}