package com.hatimaru.app;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private TodoRepository todoRepo;
    private UserRepository userRepo;

    public TodoService(TodoRepository todoRepo, UserRepository userRepo) {
        this.todoRepo = todoRepo;
        this.userRepo = userRepo;
    }

    Optional<Todo> get(UUID id) {
        return todoRepo.findById(id);
    }

    List<Todo> getTodos() {
        return todoRepo.findAll();
    }

    Todo create(String title, String description) {
        User user = userRepo.findUserById(UUID.fromString("f5a49337-4c57-4d81-b6d8-9fd62ee1c155"));
        return todoRepo.save(new Todo(user, Optional.empty(), title, description));
    }

    Todo save(Todo todo) {
        return todoRepo.save(todo);
    }

    void delete(UUID id) {
        todoRepo.deleteById(id);
    }
}
