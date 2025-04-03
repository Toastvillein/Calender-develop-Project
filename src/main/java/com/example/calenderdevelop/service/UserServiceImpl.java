package com.example.calenderdevelop.service;

import com.example.calenderdevelop.config.PasswordEncoder;
import com.example.calenderdevelop.dto.response.LoginResponseDto;
import com.example.calenderdevelop.dto.response.UserResponseDto;
import com.example.calenderdevelop.entity.User;
import com.example.calenderdevelop.exception.CustomException;
import com.example.calenderdevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDto createUser(String username, String email, String password) {

        String encodedPassword = passwordEncoder.encode(password);

        User user = new User(username,email,encodedPassword);

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

        User user = userRepository.findUserByIdOrElseThrow(id);

        boolean matches = passwordEncoder.matches(password, user.getPassword());

        if(!matches){
            throw new CustomException("비밀번호가 일치하지 않습니다");
        }

        String encodedPassword = passwordEncoder.encode(password);

        user.updateUser(email,encodedPassword);

        return new UserResponseDto(user);
    }

    @Override
    public void deleteUser(Long id,String password) {

        User user = userRepository.findUserByIdOrElseThrow(id);

        boolean matches = passwordEncoder.matches(password, user.getPassword());

        if(!matches){
            throw new CustomException("비밀번호가 일치하지 않습니다");
        }

        userRepository.delete(user);

    }

    @Override
    public LoginResponseDto login(String email, String password) {
        
        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new IllegalArgumentException("사용자 찾을수 없음"));

        boolean matches = passwordEncoder.matches(password, user.getPassword());
        if(!matches){
            throw new CustomException("비밀번호가 일치하지 않습니다");
        }


        return new LoginResponseDto(user.getId());

    }
}
