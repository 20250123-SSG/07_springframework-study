package com.ino.webmvc.controller;

import com.ino.webmvc.dto.NoticeDto;
import com.ino.webmvc.service.NoticeService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;
    // final을 붙이고 final이 붙은 필드에만 생성자 만들어주도록 @RequiredArgsConstructor 어노테이션 붙여주기

    @GetMapping("/list.page")
    public String pageList(Model model){

        List<NoticeDto> list = noticeService.getAllNotice();
        model.addAttribute("list", list);
        return "/notice/list";
    }

    @GetMapping("/detail.page")
    public ModelAndView noticeDetail(int no, ModelAndView modelView){
        modelView.addObject("notice",  noticeService.getNoticeByNo(no));
        modelView.setViewName("/notice/detail");
        return modelView;
    }

    @GetMapping("/modify.page")
    public String modifyDetail(int no, Model model){
        model.addAttribute("notice", noticeService.getNoticeByNo(no));
        return "/notice/modify";
    }

    @PostMapping("/modify.do")
    public String modifyDetail(NoticeDto noticeDto, RedirectAttributes ra){
        int result = noticeService.editNotice(noticeDto);
        if(result>0){
            log.debug("modify success");
            ra.addFlashAttribute("message", "successed");
        }else{
            ra.addFlashAttribute("message", "failed");
            log.debug("modify failure");
        }
        return "redirect:/notice/detail.page?no="+noticeDto.getNo();
    }
}
