package com.example.calenderdevelop.service;

import com.example.calenderdevelop.dto.UserResponseDto;

public interface UserService {
    UserResponseDto createUser(String username,String email);
}
