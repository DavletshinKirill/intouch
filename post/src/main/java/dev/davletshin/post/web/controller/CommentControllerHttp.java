package dev.davletshin.post.web.controller;

import dev.davletshin.post.domain.post.Comment;
import dev.davletshin.post.service.interfaces.CommentService;
import dev.davletshin.post.web.DTO.CommentDTO;
import dev.davletshin.post.web.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/comments")
public class CommentControllerHttp {
    private final CommentService commentService;
    private final CommentMapper commentMapper;

    @GetMapping("/get/{post_id}")
    public Set<CommentDTO> getComments(@PathVariable Long post_id,
                                       @RequestParam(defaultValue = "0") int pageNo,
                                       @RequestParam(defaultValue = "10") int pageSize) {
        Set<Comment> comments = commentService.getComments(post_id, pageNo, pageSize);
        return commentMapper.toDTO(comments);
    }
}
