package dev.davletshin.user.web.mapper;

import dev.davletshin.user.domain.user.UserEntity;
import dev.davletshin.user.web.DTO.UserDTO;
import org.mapstruct.Mapper;
import dev.davletshin.common.web.mapper.Mappable;

@Mapper
public interface UserMapper extends Mappable<UserEntity, UserDTO> {
}
