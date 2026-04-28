package com.proyecto2027.notificationhub.infrastructure.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "notification_attempts")
class NotificationAttemptEntity {

    @Id
    private UUID id;

    @Column(nullable = false)
    private UUID eventId;

    @Column(nullable = false)
    private String eventType;

    @Column(nullable = false)
    private String recipient;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NotificationAttemptStatus status;

    @Column(columnDefinition = "text")
    private String detail;

    @Column(nullable = false)
    private Instant attemptedAt;

    protected NotificationAttemptEntity() {
    }

    public NotificationAttemptEntity(
            UUID id,
            UUID eventId,
            String eventType,
            String recipient,
            NotificationAttemptStatus status,
            String detail,
            Instant attemptedAt
    ) {
        this.id = id;
        this.eventId = eventId;
        this.eventType = eventType;
        this.recipient = recipient;
        this.status = status;
        this.detail = detail;
        this.attemptedAt = attemptedAt;
    }
}
