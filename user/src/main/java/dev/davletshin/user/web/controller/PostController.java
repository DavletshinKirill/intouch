package dev.davletshin.user.web.controller;

import dev.davletshin.common.service.interfaces.MinioService;
import dev.davletshin.user.domain.post.Post;
import dev.davletshin.user.domain.post.PostImage;
import dev.davletshin.user.service.interfaces.post.PostService;
import dev.davletshin.user.web.DTO.ImageDTO;
import dev.davletshin.user.web.DTO.PostDTO;
import dev.davletshin.user.web.mapper.ImageMapper;
import dev.davletshin.user.web.mapper.PostMapper;
import dev.davletshin.common.web.validation.OnCreate;
import dev.davletshin.common.web.validation.OnUpdate;
import io.minio.errors.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/post")
public class PostController {

    private final PostService postService;
    private final PostMapper postMapper;
    private final MinioService minioService;
    private final ImageMapper imageMapper;


    @Operation(summary = "Get Post")
    @GetMapping("/{post_id}")
    public PostDTO getById(@PathVariable Long post_id) {
        Post post = postService.getPost(post_id);
        return postMapper.toDTO(post);
    }

    @GetMapping("/get/posts/{user_id}")
    public Set<PostDTO> getPosts(@PathVariable Long user_id,
                                 @RequestParam(defaultValue = "0") int pageNo,
                                 @RequestParam(defaultValue = "1") int pageSize) {
        Set<Post> posts = postService.getPostsByUserId(user_id, pageNo, pageSize);
        return postMapper.toDTO(posts);
    }

    @Operation(summary = "Delete Post")
    @DeleteMapping("/{post_id}")
    public void deleteById(@PathVariable Long post_id) {
        postService.deletePost(post_id);
    }

    @Operation(summary = "Update Post")
    @PutMapping("/update")
    public PostDTO updatePost(@Validated(OnUpdate.class)
                              @RequestBody PostDTO dto) {
        Post post = postMapper.toEntity(dto);
        Post updatedPost = postService.updatePost(post);
        return postMapper.toDTO(post);
    }

    @Operation(summary = "Create Post")
    @PostMapping("/create/{user_id}")
    public PostDTO createPost(@PathVariable Long user_id, @Validated(OnCreate.class) @RequestBody PostDTO postDTO) {
        Post post = postMapper.toEntity(postDTO);
        Post createdPost = postService.createPost(user_id, post);
        return postMapper.toDTO(createdPost);
    }

    @Operation(summary = "Download Image")
    @GetMapping("/download/image/{path}")
    @SneakyThrows
    public ResponseEntity<ByteArrayResource> downloadImage(@PathVariable String path) {
        byte[] data = minioService.download(path).readAllBytes();
        ByteArrayResource resource = new ByteArrayResource(data);
        return ResponseEntity
                .ok()
                .contentLength(data.length)
                .header("Content-type", "application/octet-stream")
                .header("Content-disposition", "attachment; filename=\"" + path + "\"")
                .body(resource);
    }

    @Operation(summary = "Upload Image")
    @PostMapping("/upload/image/{postId}")
    public PostDTO uploadImage(@PathVariable Long postId, ImageDTO postImageDTO) {
        PostImage postImage = imageMapper.toEntity(postImageDTO);
        Post post = postService.uploadImage(postId, postImage);
        return postMapper.toDTO(post);
    }

    @Operation(summary = "Update Image")
    @PutMapping("/update/image/{postId}")
    public PostDTO updateImage(@PathVariable Long postId, ImageDTO postImageDTO) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        PostImage postImage = imageMapper.toEntity(postImageDTO);
        Post post = postService.changeImage(postId, postImage);
        return postMapper.toDTO(post);
    }
}
