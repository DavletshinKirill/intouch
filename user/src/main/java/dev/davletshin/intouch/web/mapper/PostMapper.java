package dev.davletshin.intouch.web.mapper;

import dev.davletshin.intouch.domain.post.Post;
import dev.davletshin.intouch.web.DTO.PostDTO;
import org.mapstruct.Mapper;

@Mapper
public interface PostMapper extends Mappable<Post, PostDTO> {
}
