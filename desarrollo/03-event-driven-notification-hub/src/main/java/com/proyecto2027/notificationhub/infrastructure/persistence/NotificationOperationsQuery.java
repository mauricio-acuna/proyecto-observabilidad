package com.proyecto2027.notificationhub.infrastructure.persistence;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!in-memory")
public class NotificationOperationsQuery {

    private final SpringDataProcessedEventRepository processedEvents;
    private final SpringDataNotificationAttemptRepository attempts;
    private final SpringDataDeadLetterEventRepository deadLetters;

    public NotificationOperationsQuery(
            SpringDataProcessedEventRepository processedEvents,
            SpringDataNotificationAttemptRepository attempts,
            SpringDataDeadLetterEventRepository deadLetters
    ) {
        this.processedEvents = processedEvents;
        this.attempts = attempts;
        this.deadLetters = deadLetters;
    }

    public NotificationOperationsSnapshot snapshot() {
        return new NotificationOperationsSnapshot(
                processedEvents.count(),
                attempts.count(),
                attempts.countByStatus(NotificationAttemptStatus.SENT),
                attempts.countByStatus(NotificationAttemptStatus.FAILED),
                deadLetters.count()
        );
    }

    public record NotificationOperationsSnapshot(
            long processedEvents,
            long notificationAttempts,
            long sentNotifications,
            long failedNotifications,
            long deadLetterEvents
    ) {
    }
}
