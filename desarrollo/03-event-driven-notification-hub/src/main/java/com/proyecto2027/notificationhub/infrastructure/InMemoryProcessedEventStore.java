package com.proyecto2027.notificationhub.infrastructure;

import com.proyecto2027.notificationhub.application.ProcessedEventStore;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryProcessedEventStore implements ProcessedEventStore {

    private final Set<UUID> processed = ConcurrentHashMap.newKeySet();

    @Override
    public boolean wasProcessed(UUID eventId) {
        return processed.contains(eventId);
    }

    @Override
    public void markProcessed(UUID eventId) {
        processed.add(eventId);
    }
}
