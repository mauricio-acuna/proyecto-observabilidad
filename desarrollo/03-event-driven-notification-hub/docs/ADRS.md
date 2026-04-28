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

