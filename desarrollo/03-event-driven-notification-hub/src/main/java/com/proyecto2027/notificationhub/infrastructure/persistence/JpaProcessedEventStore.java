package com.proyecto2027.notificationhub.infrastructure.persistence;

import com.proyecto2027.notificationhub.application.ProcessedEventStore;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.UUID;

@Repository
@Profile("!in-memory")
public class JpaProcessedEventStore implements ProcessedEventStore {

    private final SpringDataProcessedEventRepository repository;

    public JpaProcessedEventStore(SpringDataProcessedEventRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean wasProcessed(UUID eventId) {
        return repository.existsById(eventId);
    }

    @Override
    public void markProcessed(UUID eventId) {
        repository.save(new ProcessedEventEntity(eventId, Instant.now()));
    }
}
