package com.ssg.app.controller;

import com.ssg.app.dto.UserDto;
import com.ssg.app.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user")
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/signup.page")
    public String signupPage() {
        return "/user/signup";
    }

    /// 로그인된 회원은 어떻게 유지하지
    @PostMapping("signup.do")
    public String signup(@ModelAttribute UserDto user, RedirectAttributes redirectAttributes) {
        int result = userService.registUser(user);
        redirectAttributes.addFlashAttribute(
                "message", result == 1 ? "회원가입성공" : "회원가입실패");

        return "redirect:/";
    }

    /**
     * 동적으로 아이디가 사용가능한지 띄워주기 위해 입력한 아이디를 db에 접근하여 유효검증
     */
    @ResponseBody
    @GetMapping("/idcheck.do")
    public String idcheck(@RequestParam String checkId) {
        int count = userService.getUserCount(checkId);

        return count == 0 ? "NOTUSED" : "USED"; //근데 컨트롤러에서 판단해서 넘기는게 맞나
        /// 이정도는 비지니스 로직이라기에는(서비스에서 처리하기에는) 애매하여 컨트롤러에서 판단하여 넘김
    }

    @PostMapping("/signin.do")
    public String signin(@ModelAttribute UserDto user,
                         HttpSession session, /// 아하 유저 이렇게 기억
                         RedirectAttributes redirectAttributes) {

        UserDto selectedUser = userService.getUser(user);

        if(selectedUser != null) {
            session.setAttribute("loginUser", selectedUser);
            redirectAttributes.addFlashAttribute("message",
                    selectedUser.getUserName() + "님 환영합니다.");
        }else {
            redirectAttributes.addFlashAttribute("message", "로그인 실패");
        }

        return "redirect:/";
    }

    @GetMapping("/signout.do")
    public String signout(HttpSession session) {
        session.invalidate();

        return "redirect:/";
    }

    @GetMapping("/myinfo.page")
    public String myinfo() {
        return "/user/myinfo";
    }

    @PostMapping("/modifyProfile.do")
    public String modifyProfile(HttpSession session, MultipartFile uploadFile) {
        ///  로그인이 된 회원의 세션이 넘겨짐
        UserDto loginUser = (UserDto) session.getAttribute("loginUser");
        int result = userService.modifyUserProfile(loginUser, uploadFile);

        return result > 0 ? "SUCCESS" : "FAIL";
    }

}
