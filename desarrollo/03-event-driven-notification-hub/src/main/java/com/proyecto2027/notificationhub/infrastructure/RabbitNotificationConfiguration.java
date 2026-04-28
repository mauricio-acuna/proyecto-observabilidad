package com.proyecto2027.notificationhub.infrastructure;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class RabbitNotificationConfiguration {

    static final String EXCHANGE_NAME = "support.events";
    static final String DEAD_LETTER_EXCHANGE_NAME = "support.events.dlx";
    static final String TICKET_CREATED_QUEUE = "notification.ticket-created";
    static final String TICKET_CREATED_DLQ = "notification.ticket-created.dlq";
    static final String TICKET_CREATED_ROUTING_KEY = "ticket.created";
    static final String TICKET_CREATED_DEAD_LETTER_ROUTING_KEY = "ticket.created.dlq";

    @Bean
    DirectExchange supportEventsExchange() {
        return new DirectExchange(EXCHANGE_NAME, true, false);
    }

    @Bean
    DirectExchange supportEventsDeadLetterExchange() {
        return new DirectExchange(DEAD_LETTER_EXCHANGE_NAME, true, false);
    }

    @Bean
    Queue ticketCreatedQueue() {
        return QueueBuilder.durable(TICKET_CREATED_QUEUE)
                .deadLetterExchange(DEAD_LETTER_EXCHANGE_NAME)
                .deadLetterRoutingKey(TICKET_CREATED_DEAD_LETTER_ROUTING_KEY)
                .build();
    }

    @Bean
    Queue ticketCreatedDeadLetterQueue() {
        return QueueBuilder.durable(TICKET_CREATED_DLQ).build();
    }

    @Bean
    Binding ticketCreatedBinding(Queue ticketCreatedQueue, DirectExchange supportEventsExchange) {
        return BindingBuilder.bind(ticketCreatedQueue)
                .to(supportEventsExchange)
                .with(TICKET_CREATED_ROUTING_KEY);
    }

    @Bean
    Binding ticketCreatedDeadLetterBinding(
            Queue ticketCreatedDeadLetterQueue,
            DirectExchange supportEventsDeadLetterExchange
    ) {
        return BindingBuilder.bind(ticketCreatedDeadLetterQueue)
                .to(supportEventsDeadLetterExchange)
                .with(TICKET_CREATED_DEAD_LETTER_ROUTING_KEY);
    }
}
