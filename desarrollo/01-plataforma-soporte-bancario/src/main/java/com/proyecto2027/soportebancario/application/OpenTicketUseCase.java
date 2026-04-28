package com.proyecto2027.soportebancario.application;

import com.proyecto2027.soportebancario.domain.SupportTicket;
import com.proyecto2027.soportebancario.domain.TicketCreatedEvent;
import com.proyecto2027.soportebancario.domain.TicketPriority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class OpenTicketUseCase {

    private final CustomerRepository customerRepository;
    private final TicketRepository ticketRepository;
    private final DomainEventPublisher eventPublisher;
    private final AuditPort auditPort;

    public OpenTicketUseCase(
            CustomerRepository customerRepository,
            TicketRepository ticketRepository,
            DomainEventPublisher eventPublisher,
            AuditPort auditPort
    ) {
        this.customerRepository = customerRepository;
        this.ticketRepository = ticketRepository;
        this.eventPublisher = eventPublisher;
        this.auditPort = auditPort;
    }

    @Transactional
    public SupportTicket execute(UUID customerId, String subject, String description, TicketPriority priority) {
        customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found: " + customerId));

        SupportTicket ticket = SupportTicket.open(customerId, subject, description, priority);
        SupportTicket saved = ticketRepository.save(ticket);

        eventPublisher.publish(TicketCreatedEvent.from(saved));
        auditPort.record("TICKET_OPENED", saved.id(), "Ticket opened with priority " + priority);

        return saved;
    }
}
