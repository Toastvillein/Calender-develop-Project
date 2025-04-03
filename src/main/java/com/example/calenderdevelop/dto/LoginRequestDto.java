package com.example.calenderdevelop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class LoginRequestDto {
    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$\n", message = "옳바른 이메일 형식이 아닙니다.")
    private final String email;

    private final String password;

    public LoginRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
