package dev.davletshin.intouch.config;


import dev.davletshin.intouch.domain.user.Role;
import dev.davletshin.intouch.domain.user.UserEntity;
import dev.davletshin.intouch.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Component
@RequiredArgsConstructor
public class Initializer {

    private final UserService userService;

    private UserEntity createUser(UUID id, String username, String password) {
        UserEntity user = new UserEntity(id, username, password, Collections.singleton( Role.ROLE_ADMIN));
        return userService.create(user);
    }


    public void initialize() {
        UserEntity user1 = createUser(randomUUID() , "kirichka27@gmail.com", "123456");
        UserEntity user2 = createUser(randomUUID(), "mikesmith@yahoo.com", "123456");
    }
}
