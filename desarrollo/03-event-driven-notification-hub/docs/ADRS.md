# ADRs iniciales

## ADR-001: Idempotencia por eventId

### Decision

Cada evento se identifica con `eventId`, y el consumidor consulta si ya fue procesado.

### Motivo

Los brokers pueden entregar duplicados. El consumidor debe ser seguro ante reintentos.

## ADR-002: Simular broker con HTTP al inicio

### Decision

El primer corte usa un endpoint REST como entrada de eventos.

### Motivo

Permite probar reglas de idempotencia antes de introducir Kafka, RabbitMQ o SQS.

## ADR-003: Consumir eventos desde RabbitMQ

### Decision

Agregar un listener RabbitMQ para la cola `notification.ticket-created`, enlazada al exchange `support.events` con routing key `ticket.created`.
El endpoint HTTP queda como entrada manual para pruebas y demos.

### Motivo

El proyecto 01 ya publica eventos desde outbox hacia RabbitMQ. Este listener permite demostrar integracion asincrona real sin cambiar el caso de uso idempotente.

### Consecuencias

- El contrato entre productor y consumidor queda basado en el payload `TicketCreated`.
- La idempotencia sigue en la capa de aplicacion.
- Retry policy y DLQ RabbitMQ quedan configurados.
- Faltan persistencia de intentos, dashboard de backlog y prueba end-to-end con Docker local.

## ADR-004: Persistir idempotencia e informacion operativa

### Decision

Guardar `processed_events`, `notification_attempts` y `dead_letter_events` en PostgreSQL usando Flyway y adapters JPA.
El store in-memory queda disponible solo con el perfil `in-memory`.

### Motivo

La idempotencia en memoria no sobrevive reinicios y no deja evidencia operacional. Persistir estos datos permite auditar duplicados, intentos y mensajes enviados a DLQ.

### Consecuencias

- El consumidor puede reiniciarse sin perder historial de eventos procesados.
- La DLQ queda consultable desde base de datos, no solo desde RabbitMQ.
- El snapshot operativo expone conteos de eventos procesados, intentos y DLQ.
- Micrometer expone gauges equivalentes para Actuator/Prometheus.
- Falta prueba end-to-end con Docker local.
