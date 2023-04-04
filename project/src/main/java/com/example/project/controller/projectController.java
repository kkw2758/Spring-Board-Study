package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 컨트롤러 선언
public class ProjectController {
    @GetMapping("/a")
    public String aaa(Model model) {
        model.addAttribute("username", "김철수");
        return "welcome";
    }
    public String index(Model model) {
        model.addAttribute("username", "김철수");
        return "index";
    }
}
