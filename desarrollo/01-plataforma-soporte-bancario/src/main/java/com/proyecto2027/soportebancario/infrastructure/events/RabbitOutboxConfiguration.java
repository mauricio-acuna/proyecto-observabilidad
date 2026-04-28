package com.proyecto2027.soportebancario.infrastructure.events;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!in-memory")
@ConditionalOnProperty(name = "app.outbox.relay.enabled", havingValue = "true", matchIfMissing = true)
class RabbitOutboxConfiguration {

    static final String EXCHANGE_NAME = "support.events";
    static final String TICKET_CREATED_QUEUE = "notification.ticket-created";
    static final String TICKET_CREATED_ROUTING_KEY = "ticket.created";

    @Bean
    DirectExchange supportEventsExchange() {
        return new DirectExchange(EXCHANGE_NAME, true, false);
    }

    @Bean
    Queue ticketCreatedQueue() {
        return new Queue(TICKET_CREATED_QUEUE, true);
    }

    @Bean
    Binding ticketCreatedBinding(Queue ticketCreatedQueue, DirectExchange supportEventsExchange) {
        return BindingBuilder.bind(ticketCreatedQueue)
                .to(supportEventsExchange)
                .with(TICKET_CREATED_ROUTING_KEY);
    }
}
