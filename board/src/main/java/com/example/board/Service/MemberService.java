package com.example.board.Service;

import com.example.board.Dto.BoardCreateRequestDto;
import com.example.board.Dto.MemberCreateDto;
import com.example.board.Entity.Member;
import com.example.board.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public Optional<Member> getMemberById(Long id) {
        return memberRepository.findById(id);
    }
    @Transactional
    public Long create(@RequestBody MemberCreateDto memberCreateDto) {
        return memberRepository.save(memberCreateDto.toEntity()).getId();
    }
}
