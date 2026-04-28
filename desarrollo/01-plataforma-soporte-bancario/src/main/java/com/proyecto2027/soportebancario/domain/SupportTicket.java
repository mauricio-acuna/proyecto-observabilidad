package com.proyecto2027.soportebancario.domain;

import java.time.Instant;
import java.util.UUID;

public record SupportTicket(
        UUID id,
        UUID customerId,
        String subject,
        String description,
        TicketPriority priority,
        TicketStatus status,
        Instant createdAt
) {
    public static SupportTicket open(UUID customerId, String subject, String description, TicketPriority priority) {
        return new SupportTicket(
                UUID.randomUUID(),
                customerId,
                subject,
                description,
                priority,
                TicketStatus.OPEN,
                Instant.now()
        );
    }

    public SupportTicket markInProgress() {
        return new SupportTicket(id, customerId, subject, description, priority, TicketStatus.IN_PROGRESS, createdAt);
    }

    public SupportTicket resolve() {
        return new SupportTicket(id, customerId, subject, description, priority, TicketStatus.RESOLVED, createdAt);
    }
}
