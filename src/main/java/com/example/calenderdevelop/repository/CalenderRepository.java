package com.example.calenderdevelop.repository;

import com.example.calenderdevelop.entity.Calender;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface CalenderRepository extends JpaRepository<Calender, Long> {

    default Calender findByIdOrElseThrow(Long id){
        return findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NO_CONTENT,"존재하지 않는 아이디입니다."));
    }

    Page<Calender> findAllByOrderByModifiedAtDesc(Pageable pageable);

}
