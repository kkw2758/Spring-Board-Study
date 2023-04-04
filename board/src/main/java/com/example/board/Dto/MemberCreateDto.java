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
public class MemberCreateDto {
    private String name;
    private String password;
    private String email;
    private String contact;

    @Builder
    public MemberCreateDto(String name, String password, String email, String contact) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.contact = contact;
    }

    public Member toEntity() {
        return Member.builder()
                .name(name)
                .password(password)
                .email(email)
                .contact(contact)
                .build();
    }

}
