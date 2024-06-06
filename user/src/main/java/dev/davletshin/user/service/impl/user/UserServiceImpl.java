package dev.davletshin.user.service.impl.user;

import dev.davletshin.user.domain.exception.ResourceNotFoundException;
import dev.davletshin.user.domain.user.Role;
import dev.davletshin.user.domain.user.UserEntity;
import dev.davletshin.user.repository.UserRepository;
import dev.davletshin.user.service.interfaces.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserEntity create(UserEntity user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalStateException("User already exist.");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (user.getRoles() == null)
            user.setRoles(Set.of(Role.ROLE_USER));
        userRepository.save(user);
        return user;
    }

    @Override
    public UserEntity update(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    @Cacheable(value = "UserService::getUserById", key = "#id")
    public UserEntity getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User by id not found exception"));
    }

    @Override
    @Cacheable(value = "UserService::getUserByUsername", key = "#username")
    public UserEntity getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User by username not found exception"));
    }

    @Override
    @CacheEvict(value = "UserService::deleteUserById", key = "#id")
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }



}
