package dev.davletshin.intouch.web.mapper;

import dev.davletshin.intouch.domain.post.PostImage;
import dev.davletshin.intouch.web.DTO.ImageDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ImageMapper extends Mappable<PostImage, ImageDTO> {
}
