package com.example.calenderdevelop.controller;

import com.example.calenderdevelop.dto.CreateUserRequestDto;
import com.example.calenderdevelop.dto.UpdateUserRequestDto;
import com.example.calenderdevelop.dto.UserResponseDto;
import com.example.calenderdevelop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAllUser(){

        List<UserResponseDto> allUser = userService.findAllUser();

        return new ResponseEntity<>(allUser,HttpStatus.OK);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(
            @PathVariable Long id,
            @RequestBody UpdateUserRequestDto dto
            ){

        UserResponseDto userResponseDto = userService.updateUser(id,dto.getEmail());

        return new ResponseEntity<>(userResponseDto,HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
