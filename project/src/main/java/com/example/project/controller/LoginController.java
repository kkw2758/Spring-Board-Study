package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 컨트롤러 선언
public class LoginController {
    @GetMapping("/login/login")
    public String login() {
        return "/login/login";
    }
}
