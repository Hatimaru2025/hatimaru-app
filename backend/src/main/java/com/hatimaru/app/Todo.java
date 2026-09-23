package com.hatimaru.app;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "todos")
public class Todo {
    @Id
    private String id;
    private String ownerId;
    private Optional<String> routineId;

    private String title;
    private String description;
    private boolean isCompleted;
    private String createdAt;
    private String updatedAt;

    protected Todo() {
    }

    public Todo(String ownerId, Optional<String> routineId, String title, String description) {

        UUID uuid = UUID.randomUUID();

        this.id = uuid.toString();
        this.ownerId = ownerId;
        this.routineId = routineId;
        this.title = title;
        this.description = description;
        this.isCompleted = false;

        String instant = Instant.now().toString();
        this.createdAt = instant;
        this.updatedAt = instant;
    }

}
