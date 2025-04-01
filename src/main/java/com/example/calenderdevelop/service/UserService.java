package com.example.calenderdevelop.service;

import com.example.calenderdevelop.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(String username,String email);

    UserResponseDto findUserById(Long id);

    List<UserResponseDto> findAllUser();

    UserResponseDto updateUser(Long id,String email);
}
