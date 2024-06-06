package dev.davletshin.common.service.interfaces;


import dev.davletshin.common.domain.image.Image;
import io.minio.errors.*;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface MinioService {
    String upload(Image image);
    InputStream download(String imagePath);

    void deleteImage(String imagePath) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException;
}
