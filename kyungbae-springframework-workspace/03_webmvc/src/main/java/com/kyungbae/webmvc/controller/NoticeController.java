package com.kyungbae.webmvc.controller;

import com.kyungbae.webmvc.dto.NoticeDto;
import com.kyungbae.webmvc.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequiredArgsConstructor // final이 붙은 필드만 생성자를 만듬
@Slf4j
@RequestMapping("/notice")
@Controller
public class NoticeController {

    // lombok을 통한 생성자가 만들어져 자동으로 @Autowired
    private final NoticeService noticeService;

    // request 영역에 담기
    // 1. Model 객체 이용하기
    @GetMapping("/list.page")
    public String noticeList(Model model){

        // 포워딩되는 페이지상에 필요한 데이터 : 공지사항 목록데이터
        List<NoticeDto> list = noticeService.getNoticeAll();
        model.addAttribute("list", list);

        return "/notice/list";
    }

    // 2. ModelAndView 객체 이용하기
    @GetMapping("/detail.page")
    public ModelAndView noticeDetail(int no, ModelAndView modelAndView){
        NoticeDto n = noticeService.getNoticeByNo(no);
        modelAndView.addObject("notice", n)
                    .setViewName("notice/detail");

        return modelAndView;
    }

    @GetMapping("/modify.page")
    public String noticeModifyForm(int no, Model model){
        model.addAttribute("notice", noticeService.getNoticeByNo(no));

        return "notice/modify";
    }


    /*
        ## redirect 시 필요한 데이터 담기
        Model 영역은 requestScope기 때문에 곧바로 forwarding 하는 페이지에서만 사용 가능
        redirect로 다른 controller가 재실행되는 순간 현재 존재했던 Model은 소멸됨
        Model 대신 RedirectAttribute에 담아주어야 함
        ** 유의사항 : RedirectAttributes에 반드시 flashAttribute로 담아야됨
                      그냥 attribute로 담으면 Model(requestScope)에 담는거와 동일한 맥락
     */
    @PostMapping("/modify.do")
    public String noticeModify(NoticeDto n, RedirectAttributes rd){
        int result = noticeService.modifyNotice(n);
        if (result > 0) {
            rd.addFlashAttribute("message", "성공적으로 수정되었습니다.");
        } else {
            rd.addFlashAttribute("message", "수정에 실패하였습니다.");
        }
        return "redirect:/notice/detail.page?no=" + n.getNo();
    }

}
