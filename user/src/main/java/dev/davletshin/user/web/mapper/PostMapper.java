package dev.davletshin.user.web.mapper;

import dev.davletshin.common.web.mapper.Mappable;
import dev.davletshin.user.domain.post.Post;
import dev.davletshin.user.web.DTO.PostDTO;
import org.mapstruct.Mapper;


@Mapper
public interface PostMapper extends Mappable<Post, PostDTO> {
}