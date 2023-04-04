package com.example.board.Dto;

import com.example.board.Entity.Board;
import com.example.board.Entity.Member;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class BoardCreateRequestDto {
    private Long memberId;
    private Member member;
    private String title;
    private String content;

    @Builder
    public BoardCreateRequestDto(Long memberId, String title, String content) {
        this.memberId = memberId;
        this.title = title;
        this.content = content;
    }

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .member(member)
                .build();
    }
}