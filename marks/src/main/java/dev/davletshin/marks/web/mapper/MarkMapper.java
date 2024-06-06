package dev.davletshin.marks.web.mapper;

import dev.davletshin.common.web.mapper.Mappable;
import dev.davletshin.marks.domain.Mark;
import dev.davletshin.marks.web.DTO.MarkDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = SubjectMapper.class)
public interface MarkMapper extends Mappable<Mark, MarkDTO> {
}
