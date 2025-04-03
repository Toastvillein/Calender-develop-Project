package com.example.calenderdevelop.service;


import com.example.calenderdevelop.dto.response.CalenderResponseDto;
import com.example.calenderdevelop.entity.Calender;
import com.example.calenderdevelop.entity.User;
import com.example.calenderdevelop.exception.CustomException;
import com.example.calenderdevelop.repository.CalenderRepository;
import com.example.calenderdevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CalenderServiceImpl implements CalenderService {

    private final CalenderRepository calenderRepository;

    private final UserRepository userRepository;

    @Override
    public CalenderResponseDto createCalender(String username, String title, String contents) {

        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new CustomException("해당 이름을 가진 유저가 없습니다.")
        );

        Calender calender = new Calender(username, title, contents, user);

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

    @Transactional
    @Override
    public CalenderResponseDto updateCalender(Long id,String title, String contents) {

        Calender findCal = calenderRepository.findByIdOrElseThrow(id);

        findCal.updateCal(title,contents);

        return new CalenderResponseDto(findCal);
    }

    @Override
    public void deleteCalender(Long id) {
        Calender findCal = calenderRepository.findByIdOrElseThrow(id);

        calenderRepository.delete(findCal);

    }


}
