package com.example.calenderdevelop.dto;

import lombok.Getter;

@Getter
public class CreateCalenderRequestDto {

    private final String username;

    private final String title;

    private final String contents;

    public CreateCalenderRequestDto(String username, String title, String contents) {
        this.username = username;
        this.title = title;
        this.contents = contents;
    }

}
