package dev.davletshin.marks.web.mapper;

import dev.davletshin.common.web.mapper.Mappable;
import dev.davletshin.marks.domain.Semester;
import dev.davletshin.marks.web.DTO.SemesterDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = GroupMapper.class)
public interface SemesterMapper extends Mappable<Semester, SemesterDTO> {
}
