package dev.davletshin.intouch.web.DTO.auth;

import lombok.Data;

import java.util.UUID;

@Data
public class JwtResponse {
    private UUID id;
    private String username;
    private String accessToken;
    private String freshToken;
}
