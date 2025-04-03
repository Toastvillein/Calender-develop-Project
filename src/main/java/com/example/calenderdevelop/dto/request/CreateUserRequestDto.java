package com.example.calenderdevelop.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreateUserRequestDto {
    @NotBlank(message = "이름은 필수 입력 값입니다.")
    @Size(max=4,message = "이름은 4글자 이하로 작성해주세요")
    private final String username;

    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    @Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$", message = "옳바른 이메일 형식이 아닙니다.")
    private final String email;

    private final String password;

    public CreateUserRequestDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
