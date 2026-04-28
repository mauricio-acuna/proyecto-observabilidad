package com.proyecto2027.soportebancario.infrastructure.events;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "outbox_events")
class OutboxEventEntity {

    @Id
    private UUID id;

    @Column(nullable = false)
    private UUID aggregateId;

    @Column(nullable = false)
    private String eventType;

    @Column(nullable = false, columnDefinition = "text")
    private String payload;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OutboxEventStatus status;

    @Column(nullable = false)
    private Instant occurredAt;

    @Column(nullable = false)
    private Instant createdAt;

    protected OutboxEventEntity() {
    }

    OutboxEventEntity(
            UUID id,
            UUID aggregateId,
            String eventType,
            String payload,
            OutboxEventStatus status,
            Instant occurredAt,
            Instant createdAt
    ) {
        this.id = id;
        this.aggregateId = aggregateId;
        this.eventType = eventType;
        this.payload = payload;
        this.status = status;
        this.occurredAt = occurredAt;
        this.createdAt = createdAt;
    }

    UUID id() {
        return id;
    }

    UUID aggregateId() {
        return aggregateId;
    }

    String eventType() {
        return eventType;
    }

    String payload() {
        return payload;
    }

    OutboxEventStatus status() {
        return status;
    }
}
