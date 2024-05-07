package dev.davletshin.intouch.web.controller;

import dev.davletshin.intouch.domain.user.UserEntity;
import dev.davletshin.intouch.service.interfaces.AuthService;
import dev.davletshin.intouch.service.interfaces.UserService;
import dev.davletshin.intouch.web.DTO.UserDTO;
import dev.davletshin.intouch.web.DTO.auth.JwtRequest;
import dev.davletshin.intouch.web.DTO.auth.JwtResponse;
import dev.davletshin.intouch.web.mapper.UserMapper;
import dev.davletshin.intouch.web.validation.OnCreate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Validated
@Slf4j
@Tag(name = "Auth Controller", description = "Auth API")
public class AuthController {
    private final AuthService authService;
    private final UserService userService;
    private final UserMapper userMapper;

    @Operation(summary = "login")
    @PostMapping("/login")
    public JwtResponse login(@Validated @RequestBody JwtRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @Operation(summary = "register")
    @PostMapping("/register")
    public UserDTO register(@Validated(OnCreate.class) @RequestBody UserDTO userDto) {
        UserEntity user = userMapper.toEntity(userDto);
        UserEntity createdUser = userService.create(user);
        return userMapper.toDTO(createdUser);
    }

    @Operation(summary = "refresh token")
    @PostMapping("/refresh")
    public JwtResponse refresh(@RequestBody String refreshToken) {
        return authService.refresh(refreshToken);
    }
}
