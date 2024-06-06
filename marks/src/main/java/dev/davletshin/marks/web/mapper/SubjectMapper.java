package dev.davletshin.marks.web.mapper;

import dev.davletshin.common.web.mapper.Mappable;
import dev.davletshin.marks.domain.Subject;
import dev.davletshin.marks.web.DTO.SubjectDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = SemesterMapper.class)
public interface SubjectMapper extends Mappable<Subject, SubjectDTO> {
}
