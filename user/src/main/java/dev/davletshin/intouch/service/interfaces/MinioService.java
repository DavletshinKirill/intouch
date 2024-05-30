package dev.davletshin.intouch.service.interfaces;

import dev.davletshin.intouch.domain.post.PostImage;
import io.minio.errors.*;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface MinioService {
    String upload(PostImage postImage);
    InputStream download(String imagePath);

    void deleteImage(String imagePath) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException;
}
