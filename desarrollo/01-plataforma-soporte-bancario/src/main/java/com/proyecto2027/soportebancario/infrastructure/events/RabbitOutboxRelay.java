package com.proyecto2027.soportebancario.infrastructure.events;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Component
@Profile("!in-memory")
@ConditionalOnProperty(name = "app.outbox.relay.enabled", havingValue = "true", matchIfMissing = true)
public class RabbitOutboxRelay {

    private final SpringDataOutboxEventRepository repository;
    private final RabbitTemplate rabbitTemplate;

    public RabbitOutboxRelay(SpringDataOutboxEventRepository repository, RabbitTemplate rabbitTemplate) {
        this.repository = repository;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedDelayString = "${app.outbox.relay.fixed-delay-ms:5000}")
    @Transactional
    public void publishPendingEvents() {
        repository.findTop50ByStatusOrderByCreatedAtAsc(OutboxEventStatus.PENDING)
                .forEach(this::publish);
    }

    private void publish(OutboxEventEntity event) {
        try {
            rabbitTemplate.convertAndSend(
                    RabbitOutboxConfiguration.EXCHANGE_NAME,
                    RabbitOutboxConfiguration.TICKET_CREATED_ROUTING_KEY,
                    event.payload(),
                    message -> {
                        message.getMessageProperties().setMessageId(event.id().toString());
                        message.getMessageProperties().setType(event.eventType());
                        message.getMessageProperties().setHeader("aggregateId", event.aggregateId().toString());
                        return message;
                    }
            );
            event.markPublished(Instant.now());
        } catch (RuntimeException exception) {
            event.markFailed(exception.getMessage());
        }
    }
}
