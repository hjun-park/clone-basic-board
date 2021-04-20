package com.clone.board.service;

import com.clone.board.dto.BoardDto;
import com.clone.board.entity.BoardEntity;
import com.clone.board.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
@Service
public class BoardService {
    private BoardRepository boardRepository;

    public List<BoardDto> getBoardlist() {
        List<BoardEntity> boardEntities = boardRepository.findAll();
        List<BoardDto> boardDtoList = boardEntities
                .stream()
                .map(BoardDto::new)
                .collect(Collectors.toList());

        return boardDtoList;
    }


    @Transactional
    public Long savePost(BoardDto boardDto) {
        return boardRepository.save(boardDto.toEntity()).getId();
    }
}