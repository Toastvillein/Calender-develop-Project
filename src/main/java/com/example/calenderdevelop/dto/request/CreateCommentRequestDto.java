package com.example.calenderdevelop.dto.request;

import lombok.Getter;

@Getter
public class CreateCommentRequestDto {

    private final String comments;

    public CreateCommentRequestDto(String comments) {
        this.comments = comments;
    }
}
