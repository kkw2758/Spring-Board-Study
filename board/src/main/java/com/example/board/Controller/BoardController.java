package com.example.board.Controller;

import com.example.board.Dto.BoardCreateRequestDto;
import com.example.board.Dto.BoardListResponseDto;
import com.example.board.Dto.BoardResponseDto;
import com.example.board.Dto.BoardUpdateRequestDto;
import com.example.board.Entity.Member;
import com.example.board.Service.BoardService;
import com.example.board.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;
    private final MemberService memberService;

    @GetMapping("/")
    public String mainPage() {
        return "안녕";
    }
    @PostMapping("/board")
    public Long create(@RequestBody BoardCreateRequestDto requestDto) {
        Long id = requestDto.getMemberId();
        Member member = memberService.getMemberById(id).get();
        requestDto.setMember(member);

        return boardService.create(requestDto);
    }

    @PutMapping("/board/{id}")
    public Long update(@PathVariable Long id, @RequestBody BoardUpdateRequestDto requestDto) {
        return boardService.update(id, requestDto);
    }

    //개별 조회
    @GetMapping("/board/{id}")
    public BoardResponseDto searchById(@PathVariable Long id) {
        return boardService.searchById(id);
    }

    //전체 조회(목록)
    @GetMapping("/board")
    public List<BoardListResponseDto> searchAllDesc() {
        return boardService.searchAllDesc();
    }
    @DeleteMapping("/board/{id}")
    public void delete(@PathVariable Long id){
        boardService.delete(id);
    }
}