# Conceptos aplicados

## Idempotent consumer

`ProcessedEventStore` evita procesar dos veces el mismo `eventId`.

## DLQ y retries

El listener RabbitMQ usa retry/backoff configurado en Spring AMQP y enruta fallos a `notification.ticket-created.dlq`.
Un listener de DLQ guarda payload, cola origen y motivo en `dead_letter_events` para auditoria.

## Event-driven architecture

RabbitMQ es la entrada asincrona principal para `ticket.created`.
El controller HTTP queda como entrada manual para pruebas, demos y diagnostico, sin cambiar el caso de uso idempotente.

## Operacion observable

`NotificationOperationsController` expone un snapshot con procesados, intentos, enviados, fallidos y dead letters.
`NotificationHubMetrics` publica gauges equivalentes para Prometheus.

## Conceptos del perfil que cubre

- Eventos.
- Idempotencia.
- Consumidores.
- Separacion puerto/adaptador.
- Observabilidad de procesamiento.
- Resiliencia.
