package com.proyecto2027.notificationhub.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataDeadLetterEventRepository extends JpaRepository<DeadLetterEventEntity, UUID> {
}
