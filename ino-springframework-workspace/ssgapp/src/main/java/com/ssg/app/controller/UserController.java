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

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/signup.page")
    public void signupPage(){}

    @PostMapping("/signup.do")
    public String signupUser(UserDto user, RedirectAttributes ra){
        int result = userService.registUser(user);
        ra.addFlashAttribute("message", result > 0 ? "register success" : "register failed");
        return "redirect:/";
    }

    @GetMapping("/idcheck.do")
    public String idcheck(String checkId){
        int result = userService.checkUser(checkId);
        return result == 0? "NOTUSED" : "USED";
    }

    @PostMapping("/signin.do")
    public String signin(UserDto user, HttpSession session, RedirectAttributes ra){
        UserDto selectedUser = userService.getUser(user);
        if(selectedUser != null){
            session.setAttribute("loginUser", selectedUser);
            ra.addFlashAttribute("message", selectedUser.getUserName() + "님, 환영합니다.");
        }else {
            ra.addFlashAttribute("message", "login fails");
        }
        return "redirect:/";

    }

    @GetMapping("/signout.do")
    public String signout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/myinfo.page")
    public void mypage(){}

    @PostMapping("/modifyProfile.do")
    @ResponseBody
    public String modifyProfile(MultipartFile uploadFile, HttpSession session){
        // now login user, user id를 멀티파트파일에 담아서 보내기보단, 여기서 세션에서 꺼냄
        UserDto loginUser = (UserDto)session.getAttribute("loginUser");
        int result = userService.modifyUserProfile(loginUser, uploadFile);
        return result > 0 ? "SUCCESS" : "FAIL";
    }
}
