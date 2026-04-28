package com.proyecto2027.soportebancario.infrastructure.persistence;

import com.proyecto2027.soportebancario.domain.SupportTicket;
import com.proyecto2027.soportebancario.domain.TicketPriority;
import com.proyecto2027.soportebancario.domain.TicketStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "support_tickets")
class JpaSupportTicketEntity {

    @Id
    private UUID id;

    @Column(nullable = false)
    private UUID customerId;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false, columnDefinition = "text")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TicketPriority priority;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TicketStatus status;

    @Column(nullable = false)
    private Instant createdAt;

    protected JpaSupportTicketEntity() {
    }

    private JpaSupportTicketEntity(
            UUID id,
            UUID customerId,
            String subject,
            String description,
            TicketPriority priority,
            TicketStatus status,
            Instant createdAt
    ) {
        this.id = id;
        this.customerId = customerId;
        this.subject = subject;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.createdAt = createdAt;
    }

    static JpaSupportTicketEntity fromDomain(SupportTicket ticket) {
        return new JpaSupportTicketEntity(
                ticket.id(),
                ticket.customerId(),
                ticket.subject(),
                ticket.description(),
                ticket.priority(),
                ticket.status(),
                ticket.createdAt()
        );
    }

    SupportTicket toDomain() {
        return new SupportTicket(id, customerId, subject, description, priority, status, createdAt);
    }
}
