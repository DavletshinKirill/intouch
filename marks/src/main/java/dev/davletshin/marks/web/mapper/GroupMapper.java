package dev.davletshin.marks.web.mapper;

import dev.davletshin.common.web.mapper.Mappable;
import dev.davletshin.marks.domain.Group;
import dev.davletshin.marks.web.DTO.GroupDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GroupMapper extends Mappable<Group, GroupDTO> {
}
