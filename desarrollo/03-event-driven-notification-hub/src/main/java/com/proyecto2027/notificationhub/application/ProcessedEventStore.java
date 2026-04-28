package com.proyecto2027.notificationhub.application;

import java.util.UUID;

public interface ProcessedEventStore {
    boolean wasProcessed(UUID eventId);

    void markProcessed(UUID eventId);
}
