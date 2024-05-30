package dev.davletshin.intouch.web.mapper;

import dev.davletshin.intouch.domain.post.Comment;
import dev.davletshin.intouch.web.DTO.CommentDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CommentMapper extends Mappable<Comment, CommentDTO> {
}
