package dev.davletshin.post.service.interfaces;

import dev.davletshin.post.domain.post.Comment;

import java.util.Set;

public interface CommentService {
    Comment createComment(Comment comment);

    Comment updateComment(Comment comment);

    void deleteComment(Long comment_id);

    Set<Comment> getComments(Long post_id, int pageNo, int pageSize);

}
