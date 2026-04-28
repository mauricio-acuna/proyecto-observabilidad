package com.proyecto2027.soportebancario.domain;

import java.time.Instant;
import java.util.UUID;

public record TicketCreatedEvent(
        UUID eventId,
        UUID ticketId,
        UUID customerId,
        TicketPriority priority,
        Instant occurredAt
) {
    public static TicketCreatedEvent from(SupportTicket ticket) {
        return new TicketCreatedEvent(
                UUID.randomUUID(),
                ticket.id(),
                ticket.customerId(),
                ticket.priority(),
                Instant.now()
        );
    }
}
