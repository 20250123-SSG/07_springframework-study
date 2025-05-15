package com.sotogito.webmvc.controller;

import com.sotogito.webmvc.dto.NoticeDto;
import com.sotogito.webmvc.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequiredArgsConstructor ///final이나 @NonNull이 붙은 필드만 골라서 생성자를 자동으로 만들어주는 Lombok 어노테이션
@Slf4j
@RequestMapping("/notice")
@Controller
public class NoticeController {

    private final NoticeService noticeService;

    /// 1. Model 객체
    @GetMapping("/list.page")
    public String noticeList(Model model) {
        /// forwarding 되는 페이지상에 필요한 데이터를 담아서 전달해야됨
        List<NoticeDto> result = noticeService.getNoticeAll();

        model.addAttribute("noticeList", result); /// Map<String, ?>

        return "notice/list";
    }

    /// 2. ModelAndView 객체 이용 (자주 안쓰임)
    @GetMapping("/detail.page")
    public ModelAndView noticeDetail(@RequestParam int no, ModelAndView mv) {///(받은거+보내는거)
        NoticeDto result = noticeService.getNoticeByNoticeNo(no);

        mv.addObject("notice", result)
          .setViewName("notice/detail");

        return mv;
    }

    @GetMapping("/modify.page")
    public String noticeModifyForm(@RequestParam int no, Model model) {
        model.addAttribute("notice", noticeService.getNoticeByNoticeNo(no)); //세부사항에서 선택된 notice를 받음

        return "notice/modify";
    }

    @PostMapping("/modify.do")
    public String noticeModify(@ModelAttribute NoticeDto noticeDto, RedirectAttributes rd) {
        int result = noticeService.modifyNotice(noticeDto);

        if(result == 1) {
            /// 디테일 페이지를 get해야하는데 매핑된 값이 있으므로 요청값에 맞추어 전닿해줘야한다.
            rd.addFlashAttribute("message","성공");
        } else {
            rd.addFlashAttribute("message","실패");
        }

        return "redirect:/notice/detail.page?no=" + noticeDto.getNo();
    }



}
