package dev.davletshin.user.service.interfaces.user;

import dev.davletshin.user.domain.user.UserEntity;


public interface UserService {

    UserEntity create(UserEntity user);

    UserEntity update(UserEntity user);

    UserEntity getUserById(Long id);

    UserEntity getUserByUsername(String username);

    void deleteUserById(Long id);
}
