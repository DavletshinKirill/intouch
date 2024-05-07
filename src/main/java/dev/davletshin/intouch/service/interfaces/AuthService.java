package dev.davletshin.intouch.service.interfaces;

import dev.davletshin.intouch.web.DTO.auth.JwtRequest;
import dev.davletshin.intouch.web.DTO.auth.JwtResponse;

public interface AuthService {
    JwtResponse login(JwtRequest loginRequest);
    JwtResponse refresh(String refreshToken);
}
