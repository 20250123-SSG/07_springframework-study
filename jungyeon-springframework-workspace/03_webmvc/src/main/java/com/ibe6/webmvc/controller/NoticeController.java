package com.ibe6.webmvc.controller;

import com.ibe6.webmvc.dto.NoticeDto;
import com.ibe6.webmvc.service.NoticeService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@RequiredArgsConstructor
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

    private final NoticeService noticeService; // 객체 주입을 받기 위한 필드
    private String name;
    private int no;
    /* @AllArgsConstructor 에 의해 만들어지는 매개변수 생성자 => String, int 빈이 없어서 문제 발생
    public NoticeController(NoticeService noticeService, String name, int no){
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
    public String noticeList(Model model){

        // 포워딩되는 페이지상에 필요한 데이터(request영역에 담기) : 공지사항 목록데이터
        List<NoticeDto> list = noticeService.getNoticeAll();
        model.addAttribute("list", list);

        return "notice/list";
    }

    // 2. ModelAndView 객체 이용
    @GetMapping("/detail.page")
    public ModelAndView noticeDetail(int no, ModelAndView mv){ // /notice/detail.page?no=x

        NoticeDto n = noticeService.getNoticeByNo(no);
        mv.addObject("notice", n)
                .setViewName("notice/detail");

        return mv;
    }

    @GetMapping("/modify.page")
    public String noticeModifyForm(int no, Model model){

        model.addAttribute("notice", noticeService.getNoticeByNo(no));

        return "notice/modify";
    }

    /*
        ## redirect시 필요한 데이터 담기

        Model 영역은 requestScope 기 때문에 곧바로 포워딩하는 페이지에서만 사용 가능
        즉, redirect로 다른 controller가 재실행되는 순간 현재 존재했던 Model은 소멸됨

        case 1)
            Model1 생성          Model1 유지
            controller ----------> jsp
                         포워딩

        case 2)
            Model1생성 Model1소멸  Model2생성           Model2유지
            controller ----------> controller -----------> jsp
                 |      redirect       |         포워딩     |
                 |                     |                    |
             /modify.do           /detail.page          /notice/detail.jsp

        case 3)
         RedirectAttributes생성                       RedirectAttributes사용가능
            controller ----------> controller -----------> jsp
                       redirect                포워딩

     */
    @PostMapping("/modify.do")
    public String noticeModify(NoticeDto n, RedirectAttributes rd){
        int result = noticeService.modifyNotice(n);
        if(result > 0){ // 성공했을 경우 => 다시 상세페이지 (redirect)
            rd.addFlashAttribute("message", "성공적으로 수정되었습니다.");
        }else{ // 실패했을 경우 => 다시 상세페이지 (redirect)
            rd.addFlashAttribute("message", "수정하는데 실패했습니다.");
        }
        return "redirect:/notice/detail.page?no=" + n.getNo();

        // * 유의사항 : RedirectAttributes에 반드시 flashAttribute로 담아야됨!
        //              그냥 attribute로 담으면 Model(requestScope)에 담은거랑 동일한 맥락
    }



}