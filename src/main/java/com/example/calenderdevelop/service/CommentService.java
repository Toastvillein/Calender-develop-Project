package com.example.calenderdevelop.service;

import com.example.calenderdevelop.dto.response.CommentResponseDto;

import java.util.List;

public interface CommentService {

    CommentResponseDto creatComment(Long id,String comments);

    List<CommentResponseDto> findCommentByID(Long id);

    CommentResponseDto updateComment(Long userId, Long id, String comments);

    void deleteComment(Long userId, Long id);
}
