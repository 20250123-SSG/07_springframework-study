package com.ssg.app.controller;

import com.ssg.app.dto.UserDto;
import com.ssg.app.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequiredArgsConstructor
@RequestMapping("/user")
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/signup.page") //   /user/signup.page  => /WEB-INF/views/user/signup.jsp
    public void signupPage(){}

    @PostMapping("/signup.do")
    public String signup(UserDto user, RedirectAttributes redirectAttributes){
        int result = userService.registUser(user);
        redirectAttributes.addFlashAttribute("message", result > 0 ? "회원가입 성공" : "회원가입 실패");
        return "redirect:/";
    }

    @ResponseBody
    @GetMapping("/idcheck.do")
    public String idcheck(String checkId){
        int count = userService.getUserCount(checkId);
        return count == 0 ? "NOTUSED" : "USED";
    }

    @PostMapping("/signin.do")
    public String signin(UserDto user, HttpSession session
            , RedirectAttributes redirectAttributes){

        UserDto selectedUser = userService.getUser(user);
        if(selectedUser != null){ // 로그인 성공
            session.setAttribute("loginUser", selectedUser);
            redirectAttributes.addFlashAttribute("message", selectedUser.getUserName() + "님 환영합니다~");
        }else { // 로그인 실패
            redirectAttributes.addFlashAttribute("message", "로그인 실패!");
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


    @ResponseBody
    @PostMapping("/modifyProfile.do")
    public String modifyProfile(MultipartFile uploadFile, HttpSession session){
        // 현재 로그인되어있는 회원
        UserDto loginUser = (UserDto)session.getAttribute("loginUser");

        int result = userService.modifyUserProfile(loginUser, uploadFile);
        return result > 0 ? "SUCCESS" : "FAIL";
    }

}