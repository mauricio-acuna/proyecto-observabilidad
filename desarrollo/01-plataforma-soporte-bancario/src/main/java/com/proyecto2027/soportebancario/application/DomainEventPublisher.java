package com.proyecto2027.soportebancario.application;

import com.proyecto2027.soportebancario.domain.TicketCreatedEvent;

public interface DomainEventPublisher {
    void publish(TicketCreatedEvent event);
}
