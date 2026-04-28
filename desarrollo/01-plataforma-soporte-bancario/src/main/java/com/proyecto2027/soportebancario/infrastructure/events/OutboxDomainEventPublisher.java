package com.proyecto2027.soportebancario.infrastructure.events;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto2027.soportebancario.application.DomainEventPublisher;
import com.proyecto2027.soportebancario.domain.TicketCreatedEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@Profile("!in-memory")
public class OutboxDomainEventPublisher implements DomainEventPublisher {

    private static final String TICKET_CREATED = "TicketCreated";

    private final SpringDataOutboxEventRepository repository;
    private final ObjectMapper objectMapper;

    public OutboxDomainEventPublisher(SpringDataOutboxEventRepository repository) {
        this.repository = repository;
        this.objectMapper = new ObjectMapper().findAndRegisterModules();
    }

    @Override
    public void publish(TicketCreatedEvent event) {
        repository.save(new OutboxEventEntity(
                event.eventId(),
                event.ticketId(),
                TICKET_CREATED,
                serialize(event),
                OutboxEventStatus.PENDING,
                event.occurredAt(),
                Instant.now()
        ));
    }

    private String serialize(TicketCreatedEvent event) {
        try {
            return objectMapper.writeValueAsString(event);
        } catch (JsonProcessingException exception) {
            throw new IllegalStateException("Could not serialize TicketCreated event", exception);
        }
    }
}
