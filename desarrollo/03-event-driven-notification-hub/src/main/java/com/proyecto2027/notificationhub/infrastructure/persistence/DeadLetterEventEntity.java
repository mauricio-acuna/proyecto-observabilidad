package com.proyecto2027.notificationhub.infrastructure.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "dead_letter_events")
class DeadLetterEventEntity {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String queueName;

    @Column(nullable = false, columnDefinition = "text")
    private String payload;

    @Column(columnDefinition = "text")
    private String failureReason;

    @Column(nullable = false)
    private Instant receivedAt;

    protected DeadLetterEventEntity() {
    }

    DeadLetterEventEntity(UUID id, String queueName, String payload, String failureReason, Instant receivedAt) {
        this.id = id;
        this.queueName = queueName;
        this.payload = payload;
        this.failureReason = failureReason;
        this.receivedAt = receivedAt;
    }
}
