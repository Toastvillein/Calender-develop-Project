package com.example.calenderdevelop.controller;

import com.example.calenderdevelop.dto.CreateUserRequestDto;
import com.example.calenderdevelop.dto.UserResponseDto;
import com.example.calenderdevelop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findUserById(@PathVariable Long id){

        UserResponseDto userById = userService.findUserById(id);

        return new ResponseEntity<>(userById,HttpStatus.OK);
    }



}
