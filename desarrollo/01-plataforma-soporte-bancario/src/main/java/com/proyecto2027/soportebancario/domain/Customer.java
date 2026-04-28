package com.proyecto2027.soportebancario.domain;

import java.time.Instant;
import java.util.UUID;

public record Customer(
        UUID id,
        String documentNumber,
        String fullName,
        String email,
        Instant createdAt
) {
    public static Customer register(String documentNumber, String fullName, String email) {
        return new Customer(UUID.randomUUID(), documentNumber, fullName, email, Instant.now());
    }
}
