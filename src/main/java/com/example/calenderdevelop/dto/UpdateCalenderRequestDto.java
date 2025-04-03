package com.example.calenderdevelop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UpdateCalenderRequestDto {

    @NotBlank(message = "제목은 필수 입력 값입니다.")
    @Size(max=10,message = "제목은 10글자 이하로 작성해주세요")
    private final String title;

    private final String contents;

    public UpdateCalenderRequestDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
