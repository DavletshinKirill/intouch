package dev.davletshin.chat.config;

import dev.davletshin.chat.domain.Chat;
import dev.davletshin.chat.web.mapper.ChatMapper;
import dev.davletshin.chat.web.mapper.MessageMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public MessageMapper messageMapper() {
        return Mappers.getMapper(MessageMapper.class);
    }

    @Bean
    public ChatMapper chatMapper() {
        return Mappers.getMapper(ChatMapper.class);
    }
}
