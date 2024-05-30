package dev.davletshin.intouch.domain.post;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class PostImage {
    private MultipartFile file;
}
