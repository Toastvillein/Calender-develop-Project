package com.example.calenderdevelop.controller;

import com.example.calenderdevelop.dto.CalenderResponseDto;
import com.example.calenderdevelop.dto.CreateCalenderRequestDto;
import com.example.calenderdevelop.dto.UpdateCalenderRequestDto;
import com.example.calenderdevelop.service.CalenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calenders")
@RequiredArgsConstructor
public class CalenderController {

    private final CalenderService calenderService;

    @PostMapping
    public ResponseEntity<CalenderResponseDto> createCalender(
            @RequestBody CreateCalenderRequestDto dto
    ){
        CalenderResponseDto create = calenderService.createCalender(dto.getUsername(), dto.getTitle(), dto.getContents());

        return new ResponseEntity<>(create,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CalenderResponseDto> findByID(@PathVariable Long id){

        CalenderResponseDto findById = calenderService.findById(id);

        return new ResponseEntity<>(findById,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CalenderResponseDto>> findAll(){

        List<CalenderResponseDto> all = calenderService.findAll();

        return new ResponseEntity<>(all,HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CalenderResponseDto> updateCalender(
            @PathVariable Long id,
            @RequestBody UpdateCalenderRequestDto dto
    ){
        CalenderResponseDto update = calenderService.updateCalender(id,dto.getTitle(),dto.getContents());

        return new ResponseEntity<>(update,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCalender(@PathVariable Long id){

        calenderService.deleteCalender(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
