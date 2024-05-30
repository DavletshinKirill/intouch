package dev.davletshin.intouch.config;


import dev.davletshin.intouch.domain.post.Comment;
import dev.davletshin.intouch.domain.post.Post;
import dev.davletshin.intouch.domain.user.Role;
import dev.davletshin.intouch.domain.user.Status;
import dev.davletshin.intouch.domain.user.UserEntity;
import dev.davletshin.intouch.repository.CommentRepository;
import dev.davletshin.intouch.service.interfaces.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class Initializer {

    private final UserService userService;
    private final CommentRepository commentRepository;

    private UserEntity createUser(Long id, String username, String password, Set<Post> posts) {
        Set<Role> roles = new HashSet<>();
        roles.add(Role.ROLE_ADMIN);
        roles.add(Role.ROLE_USER);
        UserEntity user = new UserEntity(id, username, password, Status.ONLINE, roles, posts);
        return userService.create(user);
    }

    private Set<Post> createSetPosts(Post post, Post post1) {
        Set<Post> posts = new HashSet<>();
        posts.add(post);
        posts.add(post1);
        return posts;
    }

    private Post createPost(Long id, String title, String photo) {
        return new Post(id, title, photo);
    }
    private Comment createComment(Long id, String title, Post post, UserEntity user) {
        Comment comment = new Comment(id, title, user, post);
        commentRepository.save(comment);
        return comment;
    }


    public void initialize() {
        Post post = createPost(1L, "title", "0e2f8d53-eb96-4726-aa61-94cc727ffb54.jpg");
        Post post1 = createPost(2L, "title1", "0e2f8d53-eb96-4726-aa61-94cc727ffb54.jpg");
        Post post2 = createPost(3L, "title2", "0e2f8d53-eb96-4726-aa61-94cc727ffb541.jpg");
        Post post3 = createPost(4L, "title3", "0e2f8d53-eb96-4726-aa61-94cc727ffb542.jpg");
        UserEntity user1 = createUser(1L, "kirichka27@gmail.com", "123456",
                createSetPosts(
                    post, post1
                ));
        UserEntity user2 = createUser(2L, "mikesmith@yahoo.com", "123456",
                createSetPosts(
                        post2, post3
                ));
        Comment comment1 = createComment(1L, "comment", post, user1);
        Comment comment2 = createComment(2L, "comment1", post, user1);
    }
}
