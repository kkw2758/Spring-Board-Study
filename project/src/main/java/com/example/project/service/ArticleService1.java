package com.example.project.service;

import com.example.project.dto.BoardForm;
import com.example.project.entity.Article;
import com.example.project.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ArticleService1 {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> list() {
        return articleRepository.findAll();
    }

    public Article view(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(BoardForm dto) {
        Article article = dto.toEntity();
        return articleRepository.save(article);
    }

    public Article update(Long id, BoardForm dto) {
        Article article = dto.toEntity();
        log.info("id:{}, article: {}", id, article.toString());

        Article target = articleRepository.findById(id).orElse(null);

        if (target == null || id != article.getId()) {
            log.info("잘못된 요청: {}, article: {}", id, article.toString());
            return null;
        }
        target.patch(article);
        Article updated = articleRepository.save(target);
        return updated;
    }

    public Article delete(Long id){
        Article target = articleRepository.findById(id).orElse(null);

        if (target == null) {
            return null;
        }
        articleRepository.delete(target);
        return target;
    }
}
