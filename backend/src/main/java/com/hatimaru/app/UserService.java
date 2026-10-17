package com.hatimaru.app;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User getUserById(UUID id) {
        return repository.findUserById(id);
    }
}
