package com.example.project.controller;

import com.example.project.dto.BoardForm;
import com.example.project.entity.Article;
import com.example.project.repository.ArticleRepository;
import com.example.project.service.ArticleService;
import com.example.project.service.ArticleServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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
        Article article = form.toEntity();

        Article saved = articleRepository.save(article);

//        System.out.println(article.toString());
//        form = articleService.save(form);

        log.info(form.toString());
        return "redirect:/board/" + saved.getId();
    }

    @GetMapping("/board/{id}")
    public String board_view(@PathVariable Long id, Model model) {
        log.info("id = " + id);
        // id를 이용하여 데이터를 가져옴
        Article articleEntity = articleRepository.findById(id).orElse(null);
        // 가져온 데이터를 모델에 등록
        model.addAttribute("article", articleEntity);
        return "/board/view";

    }

    @GetMapping("/board")
    public String board_list(Model model){
        List<Article> articleEntityList = articleRepository.findAll();
        model.addAttribute("articleList", articleEntityList);
        return "/board/list";
    }

    @GetMapping("/board/edit/{id}")
    public String board_edit(@PathVariable Long id, Model model) {
        Article articleEntity = articleRepository.findById(id).orElse(null);
        model.addAttribute("article", articleEntity);
        return "/board/update";
    }

    @PostMapping("/board/edit")
    public String board_update(BoardForm form) {

        // 수정값이 포함된 form 정보를 받아오고
        Article articleEntity = form.toEntity();
        // 수정 하고자하는 폼의 id 값을 이용해 기존의 값을 가져온다음
        Article target = articleRepository.findById(articleEntity.getId()).orElse(null);
        // 수정값을로 db로 반영해준다..
        if (target != null) {
            articleRepository.save(articleEntity);
        }

        return "redirect:/board/" + articleEntity.getId();
    }
}
