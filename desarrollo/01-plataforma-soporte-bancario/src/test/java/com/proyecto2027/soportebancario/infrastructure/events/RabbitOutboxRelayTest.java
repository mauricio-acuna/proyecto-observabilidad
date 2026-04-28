package com.proyecto2027.soportebancario.infrastructure.events;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class RabbitOutboxRelayTest {

    private final SpringDataOutboxEventRepository repository = mock(SpringDataOutboxEventRepository.class);
    private final RabbitTemplate rabbitTemplate = mock(RabbitTemplate.class);
    private final RabbitOutboxRelay relay = new RabbitOutboxRelay(repository, rabbitTemplate);

    @Test
    void publishesPendingEventsAndMarksThemAsPublished() {
        OutboxEventEntity event = pendingEvent();
        when(repository.findTop50ByStatusOrderByCreatedAtAsc(OutboxEventStatus.PENDING))
                .thenReturn(List.of(event));

        relay.publishPendingEvents();

        verify(rabbitTemplate).convertAndSend(
                eq(RabbitOutboxConfiguration.EXCHANGE_NAME),
                eq(RabbitOutboxConfiguration.TICKET_CREATED_ROUTING_KEY),
                eq(event.payload()),
                any(MessagePostProcessor.class)
        );
        assertThat(event.status()).isEqualTo(OutboxEventStatus.PUBLISHED);
    }

    @Test
    void marksEventAsFailedWhenRabbitPublishFails() {
        OutboxEventEntity event = pendingEvent();
        when(repository.findTop50ByStatusOrderByCreatedAtAsc(OutboxEventStatus.PENDING))
                .thenReturn(List.of(event));
        doThrow(new IllegalStateException("rabbit unavailable"))
                .when(rabbitTemplate)
                .convertAndSend(any(String.class), any(String.class), any(Object.class), any(MessagePostProcessor.class));

        relay.publishPendingEvents();

        assertThat(event.status()).isEqualTo(OutboxEventStatus.FAILED);
    }

    private static OutboxEventEntity pendingEvent() {
        return new OutboxEventEntity(
                UUID.randomUUID(),
                UUID.randomUUID(),
                "TicketCreated",
                "{\"ticketId\":\"123\"}",
                OutboxEventStatus.PENDING,
                Instant.parse("2026-04-28T18:45:00Z"),
                Instant.parse("2026-04-28T18:45:01Z")
        );
    }
}
