package com.example.board.Dto;

import com.example.board.Entity.Board;
import com.example.board.Entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardCreateRequestDto {
    private Member member;
    private String title;
    private String content;

    @Builder
    public BoardCreateRequestDto(Member member, String title, String content) {
        this.member = member;
        this.title = title;
        this.content = content;
    }

    public Board toEntity() {
        return Board.builder()
                .member(member)
                .title(title)
                .content(content)
                .build();
    }
}