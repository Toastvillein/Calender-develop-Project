package com.example.calenderdevelop.dto.response;

import com.example.calenderdevelop.entity.Comment;
import lombok.Getter;

@Getter
public class CommentResponseDto {

    private final Long id;

    private final String comments;


    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.comments = comment.getComments();
    }
}
