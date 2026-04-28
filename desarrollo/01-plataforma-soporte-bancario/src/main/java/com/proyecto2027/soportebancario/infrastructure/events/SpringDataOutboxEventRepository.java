package com.proyecto2027.soportebancario.infrastructure.events;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

interface SpringDataOutboxEventRepository extends JpaRepository<OutboxEventEntity, UUID> {
    List<OutboxEventEntity> findByStatusOrderByCreatedAtAsc(OutboxEventStatus status);

    List<OutboxEventEntity> findTop50ByStatusOrderByCreatedAtAsc(OutboxEventStatus status);
}
