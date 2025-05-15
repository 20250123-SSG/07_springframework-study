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

    // WEB-INF/views/user/signup.jsp 로 redirect
    @GetMapping("/signup.page")
    public void signupPage() {
    }

    @PostMapping("/signup.do")
    public String signup(UserDto userDto, RedirectAttributes redirectAttributes) {
        int result = userService.registUser(userDto);
        redirectAttributes.addFlashAttribute("message", result > 0 ? "성공" : "실패");
        return "redirect:/";
    }

    @GetMapping("/idcheck.do")
    public String idcheck(String checkId){
        int count = userService.checkUser(checkId);
        return count == 0 ? "NOTUSED" : "USED";
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
