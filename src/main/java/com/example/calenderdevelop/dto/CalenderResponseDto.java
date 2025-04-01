package com.example.calenderdevelop.dto;


import com.example.calenderdevelop.entity.Calender;
import lombok.Getter;

@Getter
public class CalenderResponseDto {

    private final Long id;

    private final String username;

    private final String title;

    private final String contents;

    public CalenderResponseDto(Calender calender) {
        this.id = calender.getId();
        this.username = calender.getUsername();
        this.title = calender.getTitle();
        this.contents = calender.getContents();
    }


}
