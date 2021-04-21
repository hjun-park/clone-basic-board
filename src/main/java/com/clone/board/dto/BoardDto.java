package com.clone.board.dto;

import com.clone.board.entity.BoardEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
    private Long id;
    private String writer;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    // toEntity : dto에서 필요한 부분을 builder 패턴을 이용해 entity로 만든다.
    // 필요한 엔티티는 이런 식으로 추가하면 된다.
    public BoardEntity toEntity(){
        return BoardEntity.builder()
                .id(id)
                .writer(writer)
                .title(title)
                .content(content)
                .build();
    }

    public BoardDto(BoardEntity boardEntity) {
        this.id = boardEntity.getId();
        this.writer = boardEntity.getWriter();
        this.title = boardEntity.getTitle();
        this.content = boardEntity.getContent();
        this.createdDate = boardEntity.getCreatedDate();
        this.modifiedDate = boardEntity.getModifiedDate();
    }

    @Builder
    public BoardDto(Long id, String title, String content, String writer, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}