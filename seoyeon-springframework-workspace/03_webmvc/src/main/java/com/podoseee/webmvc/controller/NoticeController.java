package com.podoseee.webmvc.controller;


import com.podoseee.webmvc.dto.NoticeDto;
import com.podoseee.webmvc.service.NoticeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@AllArgsConstructor
@Slf4j
@RequestMapping("/notice")
@Controller
public class NoticeController {

    /* 필드 주입
    @Autowired
    private NoticeService noticeService;
     */

    /* 메소드 주입
    private NoticeService noticeService;
    @Autowired
    public void setNoticeService(NoticeService noticeService){
        this.noticeService = noticeService;
    }
     */

    /* 생성자 주입
    private NoticeService noticeService;
    public NoticeController(NoticeService noticeService){
        this.noticeService = noticeService;
    }
     */

    private NoticeService noticeService;
    private String name;
    private int no;
    /* @AlllArgsConstructor 에 의해 만들어지는 매개변수 생성자 => String, int 빈이 없어서 문제 발생
    public NoticeController(NoticeService noticeService, String name, int no) {
        this.noticeService = noticeService;
        this.name = name;
        this.no = no;
    }
     */
    /* @RequiredArgsConstructor 에 의해 만들어지는 매개변수 생성자
    public NoticeController(final NoticeService noticeService){
        this.noticeService = noticeService;
    }
     */

    // 1. Model 객체 이용하기
    @GetMapping("/list.page")
    public String noticeList(){

        // 포워딩되는 페이지상에 필요한 데이터(request영역에 담기) : 공지사항 목록데이터
        List<NoticeDto> list = noticeService.getNoticeAll();
        model.addAttribute("list", list);

        return "notice/list";
    }

    // 2. ModelAndView 객체 이용
    @GetMapping("/detail.page")
    public String noticeDetail(int no, ModelAndView mv){ // /notice/detail.page?no=x

        NoticeDto n = noticeService.getNoticeByNo(no);
        mv.addObject("notice", n)
                .setViewName("notice.detail");

        return "notice/detail";
    }
}
