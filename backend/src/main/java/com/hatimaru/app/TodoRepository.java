package com.hatimaru.app;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, UUID> {
    Optional<Todo> findByIdAndUserId(UUID id, UUID userId);
}
