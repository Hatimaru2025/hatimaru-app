package com.hatimaru.app;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "routines")
public class Routine {

    @Id
    private String id;
    private String ownerId;
    private String title;
    private String description;
    private List<String> weekdays;
    private Optional<String> repeatUntil;
    private boolean isArchived;

    protected Routine() {
    }

    public Routine(String ownerId, String title, String description, List<String> weekdays,
            Optional<String> repeatUntil) {

        UUID uuid = UUID.randomUUID();
        this.id = uuid.toString();

        this.ownerId = ownerId;
        this.title = title;
        this.description = description;
        this.weekdays = weekdays;
        this.repeatUntil = repeatUntil;
        this.isArchived = false;
    }

}
