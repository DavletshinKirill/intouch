package dev.davletshin.intouch.web.controller;

import dev.davletshin.intouch.domain.user.UserEntity;
import dev.davletshin.intouch.service.interfaces.user.UserService;
import dev.davletshin.intouch.web.DTO.UserDTO;
import dev.davletshin.intouch.web.mapper.UserMapper;
import dev.davletshin.intouch.web.validation.OnUpdate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Validated
@Tag(name = "User Controller", description = "User API")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Operation(summary = "update user")
    @PutMapping
    public UserDTO update(@Validated(OnUpdate.class)
                          @RequestBody UserDTO dto) {
        UserEntity user = userMapper.toEntity(dto);
        UserEntity updatedUser = userService.update(user);
        return userMapper.toDTO(updatedUser);
    }

    @Operation(summary = "get user")
    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable Long id) {
        UserEntity user = userService.getUserById(id);
        return userMapper.toDTO(user);
    }

    @Operation(summary = "delete user")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }
}
