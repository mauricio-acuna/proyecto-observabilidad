package com.proyecto2027.notificationhub.application;

import com.proyecto2027.notificationhub.domain.NotificationEvent;
import com.proyecto2027.notificationhub.infrastructure.InMemoryProcessedEventStore;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

class ProcessNotificationEventUseCaseTest {

    @Test
    void ignoresDuplicateEvents() {
        AtomicInteger sends = new AtomicInteger();
        var store = new InMemoryProcessedEventStore();
        var useCase = new ProcessNotificationEventUseCase(store, event -> sends.incrementAndGet());
        var event = new NotificationEvent(UUID.randomUUID(), "TicketCreated", "ops@example.com", "payload", Instant.now());

        var first = useCase.execute(event);
        var second = useCase.execute(event);

        assertThat(first.status()).isEqualTo("PROCESSED");
        assertThat(second.status()).isEqualTo("DUPLICATE_IGNORED");
        assertThat(sends).hasValue(1);
    }
}
