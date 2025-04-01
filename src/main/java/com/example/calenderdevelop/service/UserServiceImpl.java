package com.example.calenderdevelop.service;

import com.example.calenderdevelop.dto.UserResponseDto;
import com.example.calenderdevelop.entity.User;
import com.example.calenderdevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<UserResponseDto> findAllUser() {

        return userRepository.findAll().stream()
                .map(UserResponseDto::new)
                .toList();
    }

    @Override
    public UserResponseDto updateUser(Long id,String email) {

        User userByIdOrElseThrow = userRepository.findUserByIdOrElseThrow(id);

        userByIdOrElseThrow.updateUser(email);

        return new UserResponseDto(userByIdOrElseThrow);
    }
}
