package com.example.project.controller;

import com.example.project.Repository.ArticleRepository;
import com.example.project.dto.boardForm;
import com.example.project.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class boardController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/board/write")
    public String board_write() {
        return "board/write";
    }

    @PostMapping("/board/ok")
    public String ok(boardForm form) {
        log.info(form.toString());

        Article article = form.toEntity();
        log.info("before" + article.toString());

        Article saved = articleRepository.save(article);
        log.info("after" + saved.toString());
        return "";
    }
}
