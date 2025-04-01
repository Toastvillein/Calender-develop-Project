package com.example.calenderdevelop.service;

import com.example.calenderdevelop.dto.UserResponseDto;
import com.example.calenderdevelop.entity.User;
import com.example.calenderdevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponseDto createUser(String username, String email) {

        User user = new User(username,email);

        User save = userRepository.save(user);

        return new UserResponseDto(save);
    }

    @Override
    public UserResponseDto findUserById(Long id) {

        User userByIdOrElseThrow = userRepository.findUserByIdOrElseThrow(id);

        return new UserResponseDto(userByIdOrElseThrow);
    }
}
