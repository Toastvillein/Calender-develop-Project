package com.example.calenderdevelop.repository;

import com.example.calenderdevelop.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
