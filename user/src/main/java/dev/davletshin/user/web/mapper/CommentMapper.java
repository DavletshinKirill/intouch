package dev.davletshin.user.web.mapper;

import dev.davletshin.common.web.mapper.Mappable;
import dev.davletshin.user.domain.post.Comment;
import dev.davletshin.user.web.DTO.CommentDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CommentMapper extends Mappable<Comment, CommentDTO> {
}