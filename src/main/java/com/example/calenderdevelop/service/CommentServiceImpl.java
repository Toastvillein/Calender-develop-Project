package com.example.calenderdevelop.service;


import com.example.calenderdevelop.dto.response.CommentResponseDto;
import com.example.calenderdevelop.entity.Calender;
import com.example.calenderdevelop.entity.Comment;
import com.example.calenderdevelop.entity.User;
import com.example.calenderdevelop.exception.CustomException;
import com.example.calenderdevelop.repository.CalenderRepository;
import com.example.calenderdevelop.repository.CommentRepository;
import com.example.calenderdevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    private final CalenderRepository calenderRepository;

    private final UserRepository userRepository;

    @Override
    public CommentResponseDto creatComment(Long id, String comments) {

        Calender calender = calenderRepository.findByIdOrElseThrow(id);

        User user = userRepository.findUserByIdOrElseThrow(calender.getUser().getId());

        Comment comment = new Comment(comments,user,calender);

        Comment save = commentRepository.save(comment);

        return new CommentResponseDto(save);
    }

    @Override
    public List<CommentResponseDto> findCommentByID(Long id) {

        List<Comment> comments = commentRepository.findAllByCalender_id(id);

        if(comments==null){
            throw new CustomException("해당 일정이 없습니다.");
        }

        return comments.stream()
                .map(CommentResponseDto::new)
                .toList();
    }
}
