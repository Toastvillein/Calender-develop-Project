package com.example.calenderdevelop.controller;

import com.example.calenderdevelop.dto.CalenderResponseDto;
import com.example.calenderdevelop.dto.CreateCalenderRequestDto;
import com.example.calenderdevelop.service.CalenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calenders")
@RequiredArgsConstructor
public class CalenderController {

    private final CalenderService calenderService;

    @PostMapping
    public ResponseEntity<CalenderResponseDto> createCalender(
            @RequestBody CreateCalenderRequestDto dto
    ){
        calenderService.createCalender();

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
