package dev.davletshin.user.domain.user;

import lombok.Getter;

@Getter
public enum Role {

    ROLE_ADMIN("ROLE_ADMIN_ROLE"),
    ROLE_USER("ROLE_USER_ROLE");
    private final String role;

    Role(String role) {
        this.role = role;
    }
}
