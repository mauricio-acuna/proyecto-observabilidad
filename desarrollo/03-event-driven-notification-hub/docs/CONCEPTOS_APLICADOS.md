# Conceptos aplicados

## Idempotent consumer

`ProcessedEventStore` evita procesar dos veces el mismo `eventId`.

## DLQ y retries

El codigo actual modela el consumidor. La siguiente iteracion agrega retry/backoff y una tabla o cola `dead_letter_events`.

## Event-driven architecture

El controller HTTP simula entrada de eventos. Puede reemplazarse por Kafka, RabbitMQ o AWS SQS sin cambiar el caso de uso.

## Conceptos del perfil que cubre

- Eventos.
- Idempotencia.
- Consumidores.
- Separacion puerto/adaptador.
- Observabilidad de procesamiento.
- Resiliencia.

