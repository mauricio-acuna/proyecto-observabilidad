package com.proyecto2027.notificationhub.domain;

import java.time.Instant;
import java.util.UUID;

public record NotificationEvent(
        UUID eventId,
        String type,
        String recipient,
        String payload,
        Instant occurredAt
) {
}
