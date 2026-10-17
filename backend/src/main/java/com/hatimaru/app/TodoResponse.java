package com.hatimaru.app;

import java.time.Instant;
import java.util.UUID;

public record TodoResponse(
                UUID id,
                UUID userId,
                UUID routineId,
                String title,
                String description,
                boolean isCompleted,
                Instant createdAt,
                Instant updatedAt) {

        static TodoResponse from(Todo todo) {
                return new TodoResponse(todo.getId(),
                                todo.getUser().getId(), todo.getRoutine().map(Routine::getId).orElse(null),
                                todo.getTitle(),
                                todo.getDescription(), todo.getIsCompleted(), todo.getCreatedAt(),
                                todo.getUpdatedAt());
        }
}
