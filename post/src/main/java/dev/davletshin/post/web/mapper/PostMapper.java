package dev.davletshin.post.web.mapper;

import dev.davletshin.post.domain.post.Post;
import dev.davletshin.post.web.DTO.PostDTO;
import org.mapstruct.Mapper;
import dev.davletshin.common.web.mapper.Mappable;
@Mapper
public interface PostMapper extends Mappable<Post, PostDTO> {
}
