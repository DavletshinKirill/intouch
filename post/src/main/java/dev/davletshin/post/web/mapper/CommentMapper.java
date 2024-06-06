package dev.davletshin.post.web.mapper;

import dev.davletshin.post.domain.post.Comment;
import dev.davletshin.post.web.DTO.CommentDTO;
import dev.davletshin.common.web.mapper.Mappable;
import org.mapstruct.Mapper;

@Mapper
public interface CommentMapper extends Mappable<Comment, CommentDTO> {
}
