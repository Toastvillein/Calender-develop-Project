package com.example.calenderdevelop.service;

import com.example.calenderdevelop.dto.response.CommentResponseDto;

public interface CommentService {

    CommentResponseDto creatComment(Long id,String comments);

}
