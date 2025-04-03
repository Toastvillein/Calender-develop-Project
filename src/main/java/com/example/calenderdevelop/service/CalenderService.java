package com.example.calenderdevelop.service;

import com.example.calenderdevelop.dto.response.CalenderResponseDto;
import org.springframework.data.domain.Page;

public interface CalenderService {


    CalenderResponseDto createCalender(String username, String title, String contents);


    CalenderResponseDto findById(Long id);

    Page<CalenderResponseDto> findAll(int page, int size);

    CalenderResponseDto updateCalender(Long id,String title, String contents);

    void deleteCalender(Long id);
}
