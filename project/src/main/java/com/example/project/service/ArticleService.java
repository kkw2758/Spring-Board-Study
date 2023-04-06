package com.example.project.service;

import com.example.project.dto.BoardForm;
import com.example.project.entity.Article;

import java.util.List;
import java.util.stream.Collectors;

public interface ArticleService {
    BoardForm save(BoardForm dto);
    void delete(Long id);
    // Dto를 Entity로
    default Article dtoToEntity(BoardForm dto) {
        Article article = Article.builder().id(dto.getId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();
        return article;
    }

    default BoardForm entityToDto(Article entity) {
        BoardForm dto = BoardForm.builder().id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .build();
        return dto;
    }

    // dto 리스트
    default List<BoardForm> toList(List<Article> list) {
        return list.stream().map(entity -> entityToDto(entity))
                .collect(Collectors.toList());
    }
}
