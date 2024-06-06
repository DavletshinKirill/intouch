package dev.davletshin.chat.web.mapper;

import dev.davletshin.chat.domain.Chat;
import dev.davletshin.chat.web.DTO.ChatDTO;
import dev.davletshin.common.web.mapper.Mappable;
import org.mapstruct.Mapper;

@Mapper
public interface ChatMapper extends Mappable<Chat, ChatDTO> {
}
