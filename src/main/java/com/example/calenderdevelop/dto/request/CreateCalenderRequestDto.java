package com.example.calenderdevelop.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreateCalenderRequestDto {

    @NotBlank(message = "이름은 필수 입력 값입니다.")
    @Size(max=4,message = "이름은 4글자 이하로 작성해주세요")
    private final String username;

    @NotBlank(message = "제목은 필수 입력 값입니다.")
    @Size(max=10,message = "제목은 10글자 이하로 작성해주세요")
    private final String title;

    private final String contents;

    public CreateCalenderRequestDto(String username, String title, String contents) {
        this.username = username;
        this.title = title;
        this.contents = contents;
    }

}
