package dev.davletshin.user.service.interfaces.user;

import dev.davletshin.user.web.DTO.auth.JwtRequest;
import dev.davletshin.user.web.DTO.auth.JwtResponse;

public interface AuthService {
    JwtResponse login(JwtRequest loginRequest);

    JwtResponse refresh(String refreshToken);
}
