package com.example.calenderdevelop.dto;

import lombok.Getter;

@Getter
public class deleteUserRequestDto {

    private final String password;

    public deleteUserRequestDto(String password) {
        this.password = password;
    }
}
