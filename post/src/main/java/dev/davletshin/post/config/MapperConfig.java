package dev.davletshin.post.config;

import dev.davletshin.post.web.mapper.CommentMapper;
import dev.davletshin.post.web.mapper.ImageMapper;
import dev.davletshin.post.web.mapper.PostMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

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
