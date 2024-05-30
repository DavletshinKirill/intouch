package dev.davletshin.intouch.service.impl.post;

import dev.davletshin.intouch.domain.post.Comment;
import dev.davletshin.intouch.domain.post.Post;
import dev.davletshin.intouch.domain.user.UserEntity;
import dev.davletshin.intouch.repository.CommentRepository;
import dev.davletshin.intouch.service.interfaces.post.CommentService;
import dev.davletshin.intouch.service.interfaces.post.PostService;
import dev.davletshin.intouch.service.interfaces.user.UserService;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
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
    private final UserService userService;

    @Override
    public Comment createComment(Comment comment) {
        Long userId = comment.getUser().getId();
        Long postId = comment.getPost().getId();
        UserEntity user = userService.getUserById(userId);
        Post post = postService.getPost(postId);

        Comment commentSaved = new Comment();
        commentSaved.setComment(comment.getComment());
        commentSaved.setUser(user);
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
