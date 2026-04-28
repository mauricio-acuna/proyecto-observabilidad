# Event-driven Notification Hub

## Problema real que resuelve

Los sistemas enterprise necesitan enviar notificaciones y ejecutar acciones asincronas sin bloquear la operacion principal. Si una notificacion falla, no debe romper el flujo de negocio.

Este proyecto demuestra arquitectura orientada a eventos, resiliencia e idempotencia.

## Capacidades funcionales

- Recepcion de eventos de negocio.
- Consumo RabbitMQ de eventos `ticket.created`.
- Envio de email/SMS simulado.
- Reintentos controlados.
- DLQ para mensajes fallidos.
- Idempotencia persistente por event ID.
- Auditoria de procesamiento.
- Dashboard de errores.

## Stack aplicado

- Java 21.
- Spring Boot 3.
- Kafka, RabbitMQ o AWS SQS/SNS.
- PostgreSQL.
- Redis opcional para idempotencia.
- Testcontainers.
- Micrometer.
- OpenTelemetry.
- Docker Compose.

## Patrones y soluciones

- Event-driven architecture.
- Pub/sub.
- Consumer groups.
- Idempotent consumer.
- Retry with exponential backoff.
- Dead-letter queue.
- Outbox pattern.
- Eventual consistency.
- Circuit breaker para proveedores externos.

## Diseno sugerido

Eventos:

- `TicketCreated`
- `PaymentFailed`
- `CustomerVerified`
- `NotificationRequested`

Integracion actual:

- Exchange: `support.events`.
- Queue: `notification.ticket-created`.
- Routing key: `ticket.created`.
- Dead-letter exchange: `support.events.dlx`.
- Dead-letter queue: `notification.ticket-created.dlq`.
- Productor esperado: outbox relay de `01-plataforma-soporte-bancario`.

Persistencia operativa:

- `processed_events`: evita reprocesar eventos duplicados.
- `notification_attempts`: registra envios simulados.
- `dead_letter_events`: guarda payloads recibidos desde la DLQ.

Retry del listener:

- 3 intentos por defecto.
- Rechazo sin requeue al agotar intentos.
- Enrutamiento a DLQ por configuracion de RabbitMQ.

Tablas:

- `processed_events`
- `notification_attempts`
- `dead_letter_events`

## Que se puede defender en entrevista

- Por que exactamente-once suele ser una simplificacion peligrosa.
- Como lograr procesamiento efectivo idempotente.
- Cuando usar colas y cuando no.
- Como evitar duplicados.
- Como observar backlog, errores y retries.
- Como separar transaccion de negocio y publicacion de eventos.

## Entregables

- Productor de eventos.
- Consumidor idempotente.
- DLQ visible.
- Tests con Testcontainers.
- Dashboard de procesamiento.
- ADR sobre eleccion Kafka/RabbitMQ/SQS.
