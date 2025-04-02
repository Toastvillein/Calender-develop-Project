package com.example.calenderdevelop.service;

import com.example.calenderdevelop.dto.LoginResponseDto;
import com.example.calenderdevelop.dto.UserResponseDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(String username,String email, String password);

    UserResponseDto findUserById(Long id);

    List<UserResponseDto> findAllUser();

    UserResponseDto updateUser(Long id,String email,String password);

    void deleteUser(Long id,String password);

    LoginResponseDto login(@NotBlank String username, @NotNull String password);
}
