package dev.davletshin.post.web.mapper;

import dev.davletshin.post.domain.post.PostImage;
import dev.davletshin.post.web.DTO.ImageDTO;
import org.mapstruct.Mapper;
import dev.davletshin.common.web.mapper.Mappable;
@Mapper
public interface ImageMapper extends Mappable<PostImage, ImageDTO> {
}
