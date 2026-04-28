package com.proyecto2027.incidents.domain;

import java.time.Instant;
import java.util.UUID;

public record Incident(
        UUID id,
        String serviceName,
        Severity severity,
        IncidentStatus status,
        String summary,
        Instant openedAt
) {
    public static Incident open(String serviceName, Severity severity, String summary) {
        return new Incident(UUID.randomUUID(), serviceName, severity, IncidentStatus.OPEN, summary, Instant.now());
    }
}
