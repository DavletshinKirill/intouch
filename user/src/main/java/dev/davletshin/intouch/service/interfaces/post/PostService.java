package dev.davletshin.intouch.service.interfaces.post;

import dev.davletshin.intouch.domain.post.Post;
import dev.davletshin.intouch.domain.post.PostImage;
import io.minio.errors.*;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Set;

public interface PostService {
    Post createPost(Long user_id, Post post);

    Post updatePost(Post post);

    void deletePost(Long post_id);

    Post getPost(Long post_id);

    Set<Post> getPostsByUserId(Long user_id, int pageNo, int pageSize);

    Post uploadImage(Long postId, PostImage postImage);

    Post changeImage(Long postId, PostImage postImage) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException;
}
