package com.example.project.dto;

import com.example.project.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@ToString
public class boardForm {
    private String title;
    private String content;

//    public boardForm(String title, String content) {
//        this.title = title;
//        this.content = content;
//
//    }

//    @Override
//    public String toString() {
//        return "boardForm{" +
//                "title='" + title + '\'' +
//                ", content='" + content + '\'' +
//                '}';
//    }
    public Article toEntity() {
        return new Article(null, title, content);
    }
}
