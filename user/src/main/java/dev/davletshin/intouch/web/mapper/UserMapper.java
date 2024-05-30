package dev.davletshin.intouch.web.mapper;

import dev.davletshin.intouch.domain.user.UserEntity;
import dev.davletshin.intouch.web.DTO.UserDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper extends Mappable<UserEntity, UserDTO> {
}
