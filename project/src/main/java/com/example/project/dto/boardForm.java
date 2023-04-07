package com.example.project.dto;

import com.example.project.entity.Article;
import lombok.*;


@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
public class BoardForm {
    private Long id;
    private String title;
    private String content;

//    public boardForm(String title, String content) {
//        this.title = title;
//        this.content = content;
//    }

//    @Override
//    public String toString() {
//        return "boardForm{" +
//                "title='" + title + '\'' +
//                ", content='" + content + '\'' +
//                '}';
//    }

    public Article toEntity() {
        return new Article(id, title, content);
    }
}
