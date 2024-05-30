package dev.davletshin.intouch.service.interfaces.user;

import dev.davletshin.intouch.domain.post.Post;
import dev.davletshin.intouch.domain.user.UserEntity;
import org.springframework.data.domain.Pageable;

import java.util.Set;


public interface UserService {

    UserEntity create(UserEntity user);

    UserEntity update(UserEntity user);

    UserEntity getUserById(Long id);

    UserEntity getUserByUsername(String username);

    void deleteUserById(Long id);
}
