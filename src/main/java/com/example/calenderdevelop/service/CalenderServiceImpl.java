package com.example.calenderdevelop.service;


import com.example.calenderdevelop.dto.CalenderResponseDto;
import com.example.calenderdevelop.entity.Calender;
import com.example.calenderdevelop.repository.CalenderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CalenderServiceImpl implements CalenderService {

    private final CalenderRepository calenderRepository;

    @Override
    public CalenderResponseDto createCalender(String username, String title, String contents) {

        Calender calender = new Calender(username, title, contents);

        Calender createCalender = calenderRepository.save(calender);

        return new CalenderResponseDto(createCalender);
    }

    @Override
    public CalenderResponseDto findById(Long id) {

        Calender findByID = calenderRepository.findByIdOrElseThrow(id);

        return new CalenderResponseDto(findByID);
    }

    @Override
    public List<CalenderResponseDto> findAll() {

        return calenderRepository.findAll().stream()
                .map(CalenderResponseDto::new)
                .toList();
    }


}
