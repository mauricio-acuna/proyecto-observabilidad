package com.proyecto2027.notificationhub.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface SpringDataProcessedEventRepository extends JpaRepository<ProcessedEventEntity, UUID> {
}
