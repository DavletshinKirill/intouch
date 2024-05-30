package dev.davletshin.intouch.web.controller;

import dev.davletshin.intouch.domain.post.Comment;
import dev.davletshin.intouch.service.interfaces.post.CommentService;
import dev.davletshin.intouch.web.DTO.CommentDTO;
import dev.davletshin.intouch.web.mapper.CommentMapper;
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
