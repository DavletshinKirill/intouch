package dev.davletshin.post.web.controller;

import dev.davletshin.post.domain.post.Comment;
import dev.davletshin.post.service.interfaces.CommentService;
import dev.davletshin.post.web.DTO.CommentDTO;
import dev.davletshin.post.web.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final CommentMapper commentMapper;

    @MessageMapping("/chat.createComment/{post_id}")
    @SendTo("/topic/comment/{post_id}")
    public CommentDTO createComment(@Payload CommentDTO commentDTO) {
        Comment comment = commentMapper.toEntity(commentDTO);
        Comment createdComment = commentService.createComment(comment);
        return commentMapper.toDTO(createdComment);
    }

    @MessageMapping("/chat.updateComment/{post_id}")
    @SendTo("/topic/comment/{post_id}")
    public CommentDTO updateComment(@Payload CommentDTO dto) {
        Comment comment = commentMapper.toEntity(dto);
        Comment updatedComment = commentService.updateComment(comment);
        return commentMapper.toDTO(updatedComment);
    }

    @MessageMapping("/chat.deleteComment/{comment_id}")
    @SendTo("/topic/comment/{post_id}")
    public void deleteComment(@Payload Long comment_id) {
        System.out.println("deleteComment");
        commentService.deleteComment(comment_id);
    }


}
