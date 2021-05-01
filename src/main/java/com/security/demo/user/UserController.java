package com.security.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "")
    public ModelAndView mainForm(User user) {
        ModelAndView mav = new ModelAndView();
        List<User> userList =  userService.selectUser(user);
        mav.setViewName("main.html");
        mav.addObject("userList", userList);
        return mav;
    }

    /**
     * 로그인 페이지
     * @return
     */
    @GetMapping(value = "/signIn")
    public String signInForm() {
        return "login.html";
    }

    /**
     * 회원가입 페이지
     * @return
     */
    @GetMapping(value = "/signUp")
    public String signUpForm() {
         return "signUp.html";
    }

    /**
     * 회원가입
     * @param user
     * @return
     */
    @PostMapping(value = "/insertUser")
    public void signUp(User user, HttpServletResponse response) {
        userService.insert(response, user);
    }

}
