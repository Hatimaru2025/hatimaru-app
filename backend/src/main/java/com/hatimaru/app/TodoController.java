package com.hatimaru.app;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/api")
@RestController
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<TodoResponse> getById(@PathVariable UUID id) {
        Optional<Todo> todo = todoService.get(id);
        if (todo.isPresent()) {
            return ResponseEntity.ok(TodoResponse.from(todo.get()));
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/todos")
    public List<TodoResponse> get() {
        return todoService.getTodos().stream().map(TodoResponse::from).toList();
    }

    @PostMapping("/todo")
    public ResponseEntity<TodoResponse> create(@RequestBody TodoDto todoDto) {

        Todo saved = todoService.create(todoDto.getTitle(), todoDto.getDescription());
        return ResponseEntity.created(URI.create("/api/todo/" + saved.getId())).body(TodoResponse.from(saved));
    }

}
