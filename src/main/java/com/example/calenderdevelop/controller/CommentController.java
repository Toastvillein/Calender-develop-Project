package com.example.calenderdevelop.controller;


import com.example.calenderdevelop.dto.request.CreateCommentRequestDto;
import com.example.calenderdevelop.dto.response.CommentResponseDto;
import com.example.calenderdevelop.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calenders/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/{id}")
    public ResponseEntity<CommentResponseDto> createComment(
            @PathVariable Long id,
            @RequestBody CreateCommentRequestDto dto){

        CommentResponseDto commentResponseDto = commentService.creatComment(id, dto.getComments());

        return new ResponseEntity<>(commentResponseDto,HttpStatus.CREATED);
    }

}
