package com.security.demo.main;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {

    /**
     * 오류페이지
     * @return
     */
    @GetMapping("/denied")
    public String deniedForm() {
        return "denied.html";
    }

}
