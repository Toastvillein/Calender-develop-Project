package com.example.calenderdevelop.service;

import com.example.calenderdevelop.dto.response.CalenderResponseDto;

import java.util.List;

public interface CalenderService {


    CalenderResponseDto createCalender(String username, String title, String contents);


    CalenderResponseDto findById(Long id);

    List<CalenderResponseDto> findAll();

    CalenderResponseDto updateCalender(Long id,String title, String contents);

    void deleteCalender(Long id);
}
