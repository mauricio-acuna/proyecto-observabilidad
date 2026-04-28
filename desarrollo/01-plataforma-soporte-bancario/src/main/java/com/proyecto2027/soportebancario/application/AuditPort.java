package com.proyecto2027.soportebancario.application;

import java.util.UUID;

public interface AuditPort {
    void record(String action, UUID aggregateId, String detail);
}
