package dev.davletshin.intouch.config;

import dev.davletshin.intouch.web.mapper.CommentMapper;
import dev.davletshin.intouch.web.mapper.ImageMapper;
import dev.davletshin.intouch.web.mapper.PostMapper;
import dev.davletshin.intouch.web.mapper.UserMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public UserMapper userMapper() {
        return Mappers.getMapper(UserMapper.class);
    }

    @Bean
    public PostMapper postMapper() {
        return Mappers.getMapper(PostMapper.class);
    }

    @Bean
    public CommentMapper commentMapper() {
        return Mappers.getMapper(CommentMapper.class);
    }
    @Bean
    public ImageMapper imageMapper(){ return  Mappers.getMapper(ImageMapper.class);}

}
