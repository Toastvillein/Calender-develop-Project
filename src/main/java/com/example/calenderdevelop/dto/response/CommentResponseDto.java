package com.example.calenderdevelop.dto.response;

import lombok.Getter;

@Getter
public class CommentResponseDto {

    private final String comments;

    public CommentResponseDto(String comments) {
        this.comments = comments;
    }
}
