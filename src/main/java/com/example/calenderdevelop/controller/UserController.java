package com.example.calenderdevelop.controller;

import com.example.calenderdevelop.common.Const;
import com.example.calenderdevelop.dto.request.CreateUserRequestDto;
import com.example.calenderdevelop.dto.request.DeleteUserRequestDto;
import com.example.calenderdevelop.dto.request.LoginRequestDto;
import com.example.calenderdevelop.dto.request.UpdateUserRequestDto;
import com.example.calenderdevelop.dto.response.LoginResponseDto;
import com.example.calenderdevelop.dto.response.UserResponseDto;
import com.example.calenderdevelop.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
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

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(
            @RequestBody @Valid LoginRequestDto dto,
            HttpServletRequest request
            ){

        LoginResponseDto responseDto = userService.login(dto.getEmail(),dto.getPassword());

        Long id = responseDto.getId();

        HttpSession session = request.getSession();

//        UserResponseDto userById = userService.findUserById(id);

        session.setAttribute(Const.Login_User,id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody @Valid CreateUserRequestDto dto){

        UserResponseDto user = userService.createUser(dto.getUsername(), dto.getEmail(),dto.getPassword());

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
            @RequestBody @Valid UpdateUserRequestDto dto
            ){

        UserResponseDto userResponseDto = userService.updateUser(id,dto.getEmail(),dto.getPassword());

        return new ResponseEntity<>(userResponseDto,HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable Long id,
            @RequestBody DeleteUserRequestDto dto
    ) {

        userService.deleteUser(id,dto.getPassword());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
