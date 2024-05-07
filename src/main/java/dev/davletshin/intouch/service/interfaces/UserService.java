package dev.davletshin.intouch.service.interfaces;

import dev.davletshin.intouch.domain.user.UserEntity;

import java.util.UUID;

public interface UserService {

    UserEntity create(UserEntity user);
    UserEntity update(UserEntity user);
    UserEntity getUserById(UUID id);
    UserEntity getUserByUsername(String username);

    void deleteUserById(UUID id);
}
