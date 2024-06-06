package dev.davletshin.post.service.impl;

import dev.davletshin.post.domain.post.Comment;
import dev.davletshin.post.domain.post.Post;
import dev.davletshin.post.repository.CommentRepository;
import dev.davletshin.post.service.interfaces.CommentService;
import dev.davletshin.post.service.interfaces.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final PostService postService;


    @Override
    public Comment createComment(Comment comment) {
        Long postId = comment.getPost().getId();
        Post post = postService.getPost(postId);

        Comment commentSaved = new Comment();
        commentSaved.setComment(comment.getComment());
        commentSaved.setPost(post);
        commentRepository.save(commentSaved);
        return comment;
    }

    @Override
    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long comment_id) {
        commentRepository.deleteById(comment_id);
    }

    @Override
    public Set<Comment> getComments(Long post_id, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Comment> comments = commentRepository.findAllByPostId(post_id, pageable);
        return comments.hasContent() ? new HashSet<>(comments.getContent()) : Collections.emptySet();
    }
}
