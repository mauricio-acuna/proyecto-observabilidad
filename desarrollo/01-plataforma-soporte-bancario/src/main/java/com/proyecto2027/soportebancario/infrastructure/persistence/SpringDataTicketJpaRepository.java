package com.proyecto2027.soportebancario.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

interface SpringDataTicketJpaRepository extends JpaRepository<JpaSupportTicketEntity, UUID> {
    List<JpaSupportTicketEntity> findByCustomerId(UUID customerId);
}
