package com.example.calenderdevelop.dto;

import lombok.Getter;

@Getter
public class UpdateCalenderRequestDto {

    private final String title;

    private final String contents;

    public UpdateCalenderRequestDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
