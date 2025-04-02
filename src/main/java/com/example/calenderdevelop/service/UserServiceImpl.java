package com.example.calenderdevelop.service;

import com.example.calenderdevelop.dto.UserResponseDto;
import com.example.calenderdevelop.entity.User;
import com.example.calenderdevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponseDto createUser(String username, String email, String password) {

        User user = new User(username,email,password);

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

    @Transactional
    @Override
    public UserResponseDto updateUser(Long id,String email,String password) {

        User userByIdOrElseThrow = userRepository.findUserByIdOrElseThrow(id);

        if(!userByIdOrElseThrow.getPassword().equals(password)){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"비밀번호가 일치하지 않습니다.");
        }

        userByIdOrElseThrow.updateUser(email,password);

        return new UserResponseDto(userByIdOrElseThrow);
    }

    @Override
    public void deleteUser(Long id,String password) {

        User userByIdOrElseThrow = userRepository.findUserByIdOrElseThrow(id);

        if(!userByIdOrElseThrow.getPassword().equals(password)){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"비밀번호가 일치하지 않습니다.");
        }

        userRepository.delete(userByIdOrElseThrow);

    }
}
