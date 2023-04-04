package com.example.board.Controller;

import com.example.board.Dto.MemberCreateDto;
import com.example.board.Entity.Member;
import com.example.board.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    @PostMapping("/member/create")
    public Long memberCreate(@RequestBody MemberCreateDto memberCreateDto) {
        return memberService.create(memberCreateDto);
    }

}
