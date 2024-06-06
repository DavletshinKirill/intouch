package dev.davletshin.user.web.mapper;

import dev.davletshin.user.domain.post.PostImage;
import dev.davletshin.user.web.DTO.ImageDTO;
import org.mapstruct.Mapper;
import dev.davletshin.common.web.mapper.Mappable;

@Mapper
public interface ImageMapper extends Mappable<PostImage, ImageDTO> {
}
