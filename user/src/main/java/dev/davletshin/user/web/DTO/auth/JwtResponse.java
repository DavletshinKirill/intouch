package dev.davletshin.user.web.DTO.auth;

import lombok.Data;

@Data
public class JwtResponse {
    private Long id;
    private String username;
    private String accessToken;
    private String freshToken;
}
