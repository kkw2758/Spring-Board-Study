package com.example.board.Dto;

import com.example.board.Entity.Board;
import com.example.board.Entity.Member;
import lombok.Getter;

@Getter
public class BoardResponseDto {
    private Long id;
    private Member member;
    private String title;
    private String content;

    public BoardResponseDto(Board entity) {
        this.id = entity.getId();
        this.member = entity.getMember();
        this.title = entity.getTitle();
        this.content = entity.getContent();
    }
}