package com.security.demo.controller;

import com.security.demo.entity.User;
import com.security.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

@Controller
public class UserController {


    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public ModelAndView main() {
        ModelAndView mav = new ModelAndView();
        List<User> userList =  userRepository.findAll();
        mav.setViewName("main.html");
        mav.addObject("userList", userList);

        return mav;
    }
}
