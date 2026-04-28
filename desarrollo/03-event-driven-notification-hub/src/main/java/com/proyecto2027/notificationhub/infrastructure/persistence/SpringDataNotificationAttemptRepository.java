package com.proyecto2027.notificationhub.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SpringDataNotificationAttemptRepository extends JpaRepository<NotificationAttemptEntity, UUID> {
    List<NotificationAttemptEntity> findByEventId(UUID eventId);

    long countByStatus(NotificationAttemptStatus status);
}
