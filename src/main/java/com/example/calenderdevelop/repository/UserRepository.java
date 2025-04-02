package com.example.calenderdevelop.repository;

import com.example.calenderdevelop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    default User findUserByIdOrElseThrow(Long id){
        return findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NO_CONTENT,"존재하지 않는 아이디입니다."));
    }

    Optional<User> findByEmailAndPassword(String email, String password);

}
