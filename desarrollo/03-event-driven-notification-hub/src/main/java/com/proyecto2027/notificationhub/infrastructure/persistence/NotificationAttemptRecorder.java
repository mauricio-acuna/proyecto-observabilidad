package com.proyecto2027.notificationhub.infrastructure.persistence;

import com.proyecto2027.notificationhub.domain.NotificationEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
@Profile("!in-memory")
public class NotificationAttemptRecorder {

    private final SpringDataNotificationAttemptRepository repository;

    public NotificationAttemptRecorder(SpringDataNotificationAttemptRepository repository) {
        this.repository = repository;
    }

    public void sent(NotificationEvent event) {
        record(event, NotificationAttemptStatus.SENT, "Notification sent by logging adapter");
    }

    public void failed(NotificationEvent event, String detail) {
        record(event, NotificationAttemptStatus.FAILED, detail);
    }

    private void record(NotificationEvent event, NotificationAttemptStatus status, String detail) {
        repository.save(new NotificationAttemptEntity(
                UUID.randomUUID(),
                event.eventId(),
                event.type(),
                event.recipient(),
                status,
                detail,
                Instant.now()
        ));
    }
}
