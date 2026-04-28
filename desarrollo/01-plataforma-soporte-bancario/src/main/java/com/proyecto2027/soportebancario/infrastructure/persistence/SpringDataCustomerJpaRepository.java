package com.proyecto2027.soportebancario.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface SpringDataCustomerJpaRepository extends JpaRepository<JpaCustomerEntity, UUID> {
}
