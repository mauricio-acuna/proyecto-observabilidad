# Conceptos aplicados

## Java 21

Se usan `record` y `enum` para modelar datos inmutables y estados de dominio. Esto permite explicar Java moderno sin convertir el proyecto en una demo de sintaxis.

## Spring Boot 3

Se usa como base productiva para exponer APIs REST, validacion, health checks y metricas.

## Arquitectura hexagonal ligera

Los paquetes separan:

- `domain`: modelo de negocio.
- `application`: casos de uso y puertos.
- `infrastructure`: web, eventos, auditoria y persistencia.

El concepto profesional demostrado es separar decisiones de negocio de detalles tecnicos.

## REST y OpenAPI

Los controllers representan la API externa. La documentacion OpenAPI queda como siguiente paso natural para generar contrato visible.

## Validacion

`jakarta.validation` evita que payloads invalidos entren al caso de uso.

## Manejo de errores

`ApiExceptionHandler` centraliza errores. Esto evita respuestas inconsistentes y permite mapear excepciones a codigos HTTP.

## Eventos de dominio

`TicketCreatedEvent` demuestra como separar una accion principal de efectos secundarios como notificaciones o auditoria.

## Outbox pattern

El proyecto guarda eventos de dominio en `outbox_events` dentro de la misma transaccion del ticket.
Un relay programado publica eventos `TicketCreated` hacia RabbitMQ en el exchange `support.events` y marca cada registro como `PUBLISHED` o `FAILED`.
El adapter `LoggingDomainEventPublisher` queda disponible solo para el perfil `in-memory`.

## Observabilidad

Actuator y Micrometer quedan habilitados desde `application.yml`. Los logs incluyen espacio para trace/span id, alineado con OpenTelemetry.

## Testing

El build incluye Spring Boot Test, tests de caso de uso, tests del outbox/relay y Testcontainers preparado para validar PostgreSQL real cuando Docker este disponible.

## Conceptos del perfil que cubre

- Java moderno.
- Spring Boot.
- REST APIs.
- Microservicios.
- Testing serio.
- Observabilidad.
- Logs estructurados.
- Eventos.
- Auditoria.
- Separacion de responsabilidades.
- Diseno defendible en entrevistas senior.
