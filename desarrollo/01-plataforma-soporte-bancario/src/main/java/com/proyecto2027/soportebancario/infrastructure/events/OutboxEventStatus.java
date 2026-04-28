package com.proyecto2027.soportebancario.infrastructure.events;

enum OutboxEventStatus {
    PENDING,
    PUBLISHED,
    FAILED
}
