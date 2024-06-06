package dev.davletshin.chat.web.mapper;

import dev.davletshin.chat.domain.Message;
import dev.davletshin.chat.web.DTO.MessageDTO;
import dev.davletshin.common.web.mapper.Mappable;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = ChatMapper.class)
public interface MessageMapper extends Mappable<Message, MessageDTO> {
}
