package com.example.project.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testApiController {
    @GetMapping("/api/test")
    public String test(){
        return "test";
    }
}
