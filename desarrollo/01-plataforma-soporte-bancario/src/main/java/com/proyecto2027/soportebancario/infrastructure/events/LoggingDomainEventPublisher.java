package com.proyecto2027.soportebancario.infrastructure.events;

import com.proyecto2027.soportebancario.application.DomainEventPublisher;
import com.proyecto2027.soportebancario.domain.TicketCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggingDomainEventPublisher implements DomainEventPublisher {

    private static final Logger log = LoggerFactory.getLogger(LoggingDomainEventPublisher.class);

    @Override
    public void publish(TicketCreatedEvent event) {
        log.info("event_published type=TicketCreated eventId={} ticketId={} customerId={} priority={}",
                event.eventId(), event.ticketId(), event.customerId(), event.priority());
    }
}
