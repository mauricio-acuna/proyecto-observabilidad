package com.proyecto2027.notificationhub.infrastructure;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto2027.notificationhub.application.ProcessNotificationEventUseCase;
import com.proyecto2027.notificationhub.domain.NotificationEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
public class RabbitTicketCreatedListener {

    private final ProcessNotificationEventUseCase useCase;
    private final ObjectMapper objectMapper;
    private final String recipient;

    public RabbitTicketCreatedListener(
            ProcessNotificationEventUseCase useCase,
            @Value("${app.notifications.ticket-created-recipient:ops@example.com}") String recipient
    ) {
        this.useCase = useCase;
        this.objectMapper = new ObjectMapper().findAndRegisterModules();
        this.recipient = recipient;
    }

    @RabbitListener(queues = RabbitNotificationConfiguration.TICKET_CREATED_QUEUE)
    public ProcessNotificationEventUseCase.ProcessingResult consume(String payload) {
        TicketCreatedMessage message = deserialize(payload);
        return useCase.execute(new NotificationEvent(
                message.eventId(),
                "TicketCreated",
                recipient,
                payload,
                message.occurredAt()
        ));
    }

    private TicketCreatedMessage deserialize(String payload) {
        try {
            return objectMapper.readValue(payload, TicketCreatedMessage.class);
        } catch (JsonProcessingException exception) {
            throw new IllegalArgumentException("Invalid TicketCreated payload", exception);
        }
    }

    record TicketCreatedMessage(
            UUID eventId,
            UUID ticketId,
            UUID customerId,
            String priority,
            Instant occurredAt
    ) {
    }
}
