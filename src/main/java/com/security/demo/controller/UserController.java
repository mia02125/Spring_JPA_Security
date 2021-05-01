package com.security.demo.controller;

import com.security.demo.entity.User;
import com.security.demo.repository.UserRepository;
import com.security.demo.service.UserService;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/")
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
    @GetMapping("/signIn")
    public String signInForm() {
        return "login.html";
    }

    /**
     * 회원가입 페이지
     * @return
     */
    @GetMapping("/signUp")
    public String signUpForm() {
         return "signUp.html";
    }

    /**
     * 회원가입
     * @param user
     * @return
     */
    @PostMapping("/insertUser")
    public User signUp(User user) {
        User userInfo =  userService.insert(user);
        System.out.println("user : " + userInfo);
        return userInfo;
    }

}
