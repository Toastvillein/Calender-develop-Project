package com.example.calenderdevelop.service;

import com.example.calenderdevelop.dto.CalenderResponseDto;

public interface CalenderService {


    CalenderResponseDto createCalender(String username, String title, String contents);


    CalenderResponseDto findById(Long id);
}
