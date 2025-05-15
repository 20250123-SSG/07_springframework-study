package com.ssg.app.controller;

import com.ssg.app.dto.UserDto;
import com.ssg.app.service.UserService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequiredArgsConstructor
//빈등록하기
@RequestMapping("/user")
@Controller
public class UserController {

    private final UserService userService;

    //a태그는 getmapping
    @GetMapping("/signup.page") //user/signup.page =>포워딩 /WEB-INF/views/user/signup.jsp
    public void signup(){ //페이지이동만 하니까 void
    }

    @PostMapping("/signup.do")
    public String signup(UserDto user, RedirectAttributes redirectAttributes){
        //서비스 호출
        int result = userService.registUser(user);
        redirectAttributes.addFlashAttribute("message", result > 0 ? "회원가입 성공" : "회원가입 실패");
        return "redirect:/";
    }

    @ResponseBody // 비동기통신할때 응답 데이터 받을 수 있도록 하는 어노테이션
    @GetMapping("/idcheck.do")
    public String idcheck(String checkId){
     int count = userService.getUserCount(checkId);
     return count == 0 ? "Not Used" : "Used";
    }

    @PostMapping("/signin.do")
    public String signin(UserDto user, HttpSession session, RedirectAttributes redirectAttributes){
        UserDto selectedUser = userService.getUser(user);
        if (selectedUser != null){
            // 로그인 성공
            session.setAttribute("loginUser" , selectedUser);
            redirectAttributes.addFlashAttribute("message" , selectedUser.getUserName() + "님 환영합니다~");
        } else {
            // 실패
        }
        return "redirect:/";
    }

    @GetMapping("/signout.do")
    public String signout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/myinfo.page")
    public void myinfoPage(){}
}
