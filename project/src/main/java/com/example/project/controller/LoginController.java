package com.example.project.controller;

import com.example.project.dto.LoginD;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Log4j2
public class LoginController {
    @GetMapping("login/login")
    public String login() {
        return "login/login";
    }
//    @PostMapping("login/ok")
//    public String ok(loginForm form) {
//        System.out.println(form.toString());
//        return "";
//    }
    @PostMapping("login/ok")
    public String ok(LoginD form) {
        System.out.println("board/ok: " + form);
        return "/redirect:index";
    }
}
