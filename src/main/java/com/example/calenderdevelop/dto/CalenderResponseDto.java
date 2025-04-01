package com.example.calenderdevelop.dto;


import lombok.Getter;

@Getter
public class CalenderResponseDto {

    private final Long id;

    private final String username;

    private final String title;

    private final String contents;

    public CalenderResponseDto(Long id, String username, String title, String contents) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.contents = contents;
    }
}
