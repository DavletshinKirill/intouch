package dev.davletshin.common.domain.image;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class Image {
    private MultipartFile file;
}
