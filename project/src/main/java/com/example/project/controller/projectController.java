package com.example.project.controller;

import com.example.project.dto.boardForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class projectController {
    @GetMapping("/a")
    public String aaa(Model model) {
        model.addAttribute("username", "경일대");
        return "welcome";
    }

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }


}
