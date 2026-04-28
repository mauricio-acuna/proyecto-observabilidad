package com.proyecto2027.notificationhub.application;

import com.proyecto2027.notificationhub.domain.NotificationEvent;
import org.springframework.stereotype.Service;

@Service
public class ProcessNotificationEventUseCase {

    private final ProcessedEventStore processedEventStore;
    private final NotificationSender notificationSender;

    public ProcessNotificationEventUseCase(ProcessedEventStore processedEventStore, NotificationSender notificationSender) {
        this.processedEventStore = processedEventStore;
        this.notificationSender = notificationSender;
    }

    public ProcessingResult execute(NotificationEvent event) {
        if (processedEventStore.wasProcessed(event.eventId())) {
            return new ProcessingResult(event.eventId().toString(), "DUPLICATE_IGNORED");
        }
        notificationSender.send(event);
        processedEventStore.markProcessed(event.eventId());
        return new ProcessingResult(event.eventId().toString(), "PROCESSED");
    }

    public record ProcessingResult(String eventId, String status) {
    }
}
