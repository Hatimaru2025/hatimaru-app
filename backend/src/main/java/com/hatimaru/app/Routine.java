package com.hatimaru.app;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "routines")
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String title;
    private String description;
    private List<String> weekdays;
    private Instant repeatUntil;
    private boolean isArchived;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    protected Routine() {
    }

    public Routine(User user, String title, String description, List<String> weekdays,
            Optional<Instant> repeatUntil) {
        this.user = user;
        this.title = title;
        this.description = description;
        this.weekdays = weekdays;
        this.repeatUntil = repeatUntil.orElse(null);
        this.isArchived = false;
    }

    public UUID getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getWeekdays() {
        return weekdays;
    }

    public Optional<Instant> getRepeatUntil() {
        return Optional.ofNullable(repeatUntil);
    }

    public boolean getIsArchived() {
        return isArchived;
    }

}
