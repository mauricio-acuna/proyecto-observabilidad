package com.proyecto2027.notificationhub.infrastructure.persistence;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
@Profile("!in-memory")
public class DeadLetterEventRecorder {

    private final SpringDataDeadLetterEventRepository repository;

    public DeadLetterEventRecorder(SpringDataDeadLetterEventRepository repository) {
        this.repository = repository;
    }

    public void record(String queueName, String payload, String failureReason) {
        repository.save(new DeadLetterEventEntity(
                UUID.randomUUID(),
                queueName,
                payload,
                failureReason,
                Instant.now()
        ));
    }
}
