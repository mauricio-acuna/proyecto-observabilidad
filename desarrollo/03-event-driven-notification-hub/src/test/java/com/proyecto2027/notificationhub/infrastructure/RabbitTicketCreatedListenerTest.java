package com.proyecto2027.notificationhub.infrastructure;

import com.proyecto2027.notificationhub.application.ProcessNotificationEventUseCase;
import com.proyecto2027.notificationhub.domain.NotificationEvent;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class RabbitTicketCreatedListenerTest {

    private final ProcessNotificationEventUseCase useCase = mock(ProcessNotificationEventUseCase.class);
    private final RabbitTicketCreatedListener listener = new RabbitTicketCreatedListener(useCase, "ops@example.com");

    @Test
    void mapsTicketCreatedPayloadToNotificationEvent() {
        UUID eventId = UUID.randomUUID();
        String payload = """
                {
                  "eventId": "%s",
                  "ticketId": "%s",
                  "customerId": "%s",
                  "priority": "HIGH",
                  "occurredAt": "2026-04-28T18:55:00Z"
                }
                """.formatted(eventId, UUID.randomUUID(), UUID.randomUUID());
        when(useCase.execute(any(NotificationEvent.class)))
                .thenReturn(new ProcessNotificationEventUseCase.ProcessingResult(eventId.toString(), "PROCESSED"));

        var result = listener.consume(payload);

        assertThat(result.status()).isEqualTo("PROCESSED");
        verify(useCase).execute(new NotificationEvent(
                eventId,
                "TicketCreated",
                "ops@example.com",
                payload,
                java.time.Instant.parse("2026-04-28T18:55:00Z")
        ));
    }
}
