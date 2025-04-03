package com.example.calenderdevelop.repository;

import com.example.calenderdevelop.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByCalender_id(Long id);

    Optional<Comment> findByCalender_idAndId(Long calenderId, Long id);

}
