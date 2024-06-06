package dev.davletshin.user.service.impl.post;

import dev.davletshin.common.domain.image.Image;
import dev.davletshin.common.service.interfaces.MinioService;
import dev.davletshin.user.domain.exception.ResourceNotFoundException;
import dev.davletshin.user.domain.post.Post;
import dev.davletshin.user.domain.post.PostImage;
import dev.davletshin.user.domain.user.UserEntity;
import dev.davletshin.user.repository.PostRepository;
import dev.davletshin.user.service.interfaces.post.PostService;
import dev.davletshin.user.service.interfaces.user.UserService;
import io.minio.errors.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final UserService userService;
    private final PostRepository postRepository;
    private final MinioService minioService;
    @Override
    public Post createPost(Long user_id, Post post) {
        UserEntity user = userService.getUserById(user_id);
        Set<Post> posts = user.getPosts();
        posts.add(post);
        user.setPosts(posts);
        userService.update(user);
        return post;
    }

    @Override
    public Post updatePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void deletePost(Long post_id) {
        postRepository.deleteById(post_id);
    }

    @Override
    public Post getPost(Long post_id) {
        return postRepository.findById(post_id)
                .orElseThrow(() -> new ResourceNotFoundException("Post by id not found exception"));
    }

    @Override
    public Set<Post> getPostsByUserId(Long user_id, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Post> postPage = postRepository.findAllByUserId(user_id, pageable);
        return postPage.hasContent() ? new HashSet<>(postPage.getContent()) : Collections.emptySet();

    }

    @Override
    public Post uploadImage(Long postId, Image postImage) {
        String imageString = minioService.upload(postImage);
        Post post = getPost(postId);
        post.setPhoto(imageString);
        return postRepository.save(post);
    }

    @Override
    public Post changeImage(Long postId, Image postImage) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        Post post = getPost(postId);
        minioService.deleteImage(post.getPhoto());
        String imageString = minioService.upload(postImage);
        post.setPhoto(imageString);
        return postRepository.save(post);
    }
}
