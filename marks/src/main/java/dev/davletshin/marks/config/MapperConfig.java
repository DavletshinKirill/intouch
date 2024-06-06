package dev.davletshin.marks.config;

import dev.davletshin.marks.web.mapper.GroupMapper;
import dev.davletshin.marks.web.mapper.MarkMapper;
import dev.davletshin.marks.web.mapper.SemesterMapper;
import dev.davletshin.marks.web.mapper.SubjectMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public GroupMapper groupMapper() {
        return Mappers.getMapper(GroupMapper.class);
    }

    @Bean
    public MarkMapper markMapper() {
        return Mappers.getMapper(MarkMapper.class);
    }

    @Bean
    public SemesterMapper semesterMapper() {
        return Mappers.getMapper(SemesterMapper.class);
    }

    @Bean
    public SubjectMapper subjectMapper() {
        return Mappers.getMapper(SubjectMapper.class);
    }
}
