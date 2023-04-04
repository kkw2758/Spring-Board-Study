package com.example.project.controller;

import com.example.project.dto.BoardForm;
import com.example.project.entity.Article;
import com.example.project.repository.ArticleRepository;
import com.example.project.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class BoardController {
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleService articleService;

    @GetMapping("/board/write")
    public String board_write() {
        return "board/write";
    }
    @PostMapping("/board/ok")
    public String board_ok(BoardForm form){
        log.info(form.toString());
        //entity로 변환
        // Article article = form.toEntity();
        // System.out.println(article.toString());


        // Article saved = articleRepository.save(article);
        form = articleService.save(form);
        System.out.println(form.toString());
        return "";
    }
}
