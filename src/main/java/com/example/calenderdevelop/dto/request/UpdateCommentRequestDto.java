package com.example.calenderdevelop.dto.request;

import lombok.Getter;

@Getter
public class UpdateCommentRequestDto {
    private final Long id;

    private final String comments;

    public UpdateCommentRequestDto(Long id, String comments) {
        this.id = id;
        this.comments = comments;
    }
}
