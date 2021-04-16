package com.sideproject.board.controller;

import com.sideproject.board.dto.BoardDto;
import com.sideproject.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class BoardController {

    // 컨트롤러는 서비스에 의존함
    private final BoardService boardService;

    // 게시판 주요 기능에는 리스트와 글쓰기가 있음
    @GetMapping("/")
    public String list() {
        return "board/list.html";
    }

    // 게시판 쓰기로 이동
    @GetMapping("/post")
    public String write() {
        return "board/write.html";
    }

    // 테스트
    @GetMapping("/test")
    public String test() {
        return "hello";
    }

    @PostMapping("/post")
    public String write(BoardDto boardDto) {
        boardService.savePost(boardDto);
        return "redirect:/";
    }

}
