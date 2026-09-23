package com.hatimaru.app;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private TodoRepository todoRepo;

    public TodoService(TodoRepository todoRepo) {
        this.todoRepo = todoRepo;
    }

    Todo get(String id) {
        return todoRepo.getReferenceById(id);
    }

    void save(Todo todo) {
        todoRepo.save(todo);
    }

    void delete(String id) {
        todoRepo.deleteById(id);
    }
}
