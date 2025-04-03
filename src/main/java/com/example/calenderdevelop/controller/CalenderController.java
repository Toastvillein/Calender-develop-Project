package com.example.calenderdevelop.controller;

import com.example.calenderdevelop.dto.request.CreateCalenderRequestDto;
import com.example.calenderdevelop.dto.request.UpdateCalenderRequestDto;
import com.example.calenderdevelop.dto.response.CalenderResponseDto;
import com.example.calenderdevelop.service.CalenderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calenders")
@RequiredArgsConstructor
public class CalenderController {

    private final CalenderService calenderService;

    @PostMapping
    public ResponseEntity<CalenderResponseDto> createCalender(
            @RequestBody @Valid CreateCalenderRequestDto dto
    ){
        CalenderResponseDto create = calenderService.createCalender(dto.getUsername(), dto.getTitle(), dto.getContents());

        return new ResponseEntity<>(create,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CalenderResponseDto> findByID(@PathVariable Long id){

        CalenderResponseDto findById = calenderService.findById(id);

        return new ResponseEntity<>(findById,HttpStatus.OK);
    }

    @GetMapping("/pages")
    public ResponseEntity<Page<CalenderResponseDto>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
            ){

        Page<CalenderResponseDto> all = calenderService.findAll(page, size);

        return new ResponseEntity<>(all,HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CalenderResponseDto> updateCalender(
            @PathVariable Long id,
            @RequestBody @Valid UpdateCalenderRequestDto dto
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
