package com.example.calenderdevelop.controller;

import com.example.calenderdevelop.dto.CreateUserRequestDto;
import com.example.calenderdevelop.dto.UserResponseDto;
import com.example.calenderdevelop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody CreateUserRequestDto dto){

        UserResponseDto user = userService.createUser(dto.getUsername(), dto.getEmail());

        return new ResponseEntity<>(user,HttpStatus.CREATED);

    }



}
