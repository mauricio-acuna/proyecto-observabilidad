package com.proyecto2027.aitriage.domain;

public record TicketTriageRequest(
        String subject,
        String description,
        String customerSegment
) {
}
