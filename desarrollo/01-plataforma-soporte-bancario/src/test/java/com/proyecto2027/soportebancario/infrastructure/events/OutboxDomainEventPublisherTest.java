package com.proyecto2027.soportebancario.infrastructure.events;

import com.proyecto2027.soportebancario.application.DomainEventPublisher;
import com.proyecto2027.soportebancario.domain.TicketCreatedEvent;
import com.proyecto2027.soportebancario.domain.TicketPriority;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.Instant;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(OutboxDomainEventPublisher.class)
@Testcontainers(disabledWithoutDocker = true)
class OutboxDomainEventPublisherTest {

    @Container
    static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine")
            .withDatabaseName("proyecto2027")
            .withUsername("proyecto2027")
            .withPassword("proyecto2027");

    @DynamicPropertySource
    static void datasourceProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    private final DomainEventPublisher publisher;
    private final SpringDataOutboxEventRepository repository;

    @Autowired
    OutboxDomainEventPublisherTest(DomainEventPublisher publisher, SpringDataOutboxEventRepository repository) {
        this.publisher = publisher;
        this.repository = repository;
    }

    @Test
    void storesTicketCreatedEventAsPendingOutboxMessage() {
        UUID eventId = UUID.randomUUID();
        UUID ticketId = UUID.randomUUID();
        UUID customerId = UUID.randomUUID();
        TicketCreatedEvent event = new TicketCreatedEvent(
                eventId,
                ticketId,
                customerId,
                TicketPriority.HIGH,
                Instant.parse("2026-04-28T18:30:00Z")
        );

        publisher.publish(event);

        assertThat(repository.findByStatusOrderByCreatedAtAsc(OutboxEventStatus.PENDING))
                .singleElement()
                .satisfies(outbox -> {
                    assertThat(outbox.id()).isEqualTo(eventId);
                    assertThat(outbox.aggregateId()).isEqualTo(ticketId);
                    assertThat(outbox.eventType()).isEqualTo("TicketCreated");
                    assertThat(outbox.status()).isEqualTo(OutboxEventStatus.PENDING);
                    assertThat(outbox.payload()).contains(ticketId.toString(), customerId.toString(), "HIGH");
                });
    }
}
