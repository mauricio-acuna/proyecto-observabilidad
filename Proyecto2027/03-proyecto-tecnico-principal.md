# Proyecto tecnico principal

## Nombre recomendado

**production-java-platform**

## Objetivo

Demostrar que Mauricio esta actualizado en backend moderno y puede construir sistemas productivos con criterio senior.

Este proyecto es mas importante que acumular cursos. Debe servir para:

- actualizar narrativa tecnica,
- practicar entrevistas,
- alimentar CV y LinkedIn,
- demostrar Java moderno,
- demostrar observabilidad,
- demostrar cloud/backend operativo.

## Stack base

- Java 21.
- Spring Boot 3.
- PostgreSQL.
- Kafka, RabbitMQ o AWS SQS/SNS.
- Docker Compose.
- OpenAPI.
- JUnit 5.
- Mockito.
- Testcontainers.
- GitHub Actions.
- Micrometer.
- OpenTelemetry.
- Prometheus/Grafana o CloudWatch.

## Servicios

### customer-service

Responsable de clientes.

Debe incluir:

- CRUD controlado,
- validaciones,
- errores bien modelados,
- persistencia PostgreSQL,
- API documentada.

### ticket-service

Responsable de tickets de soporte.

Debe incluir:

- creacion de tickets,
- cambio de estado,
- consulta por cliente,
- publicacion de evento al crear ticket.

### notification-service

Responsable de consumir eventos y simular notificaciones.

Debe incluir:

- consumidor idempotente,
- reintentos,
- DLQ,
- logs correlacionados.

### audit-service

Responsable de auditoria funcional.

Debe incluir:

- registro de eventos relevantes,
- busqueda por entidad,
- metricas simples.

## Features obligatorias

- REST APIs limpias.
- Validacion.
- Manejo global de errores.
- OpenAPI/Swagger.
- PostgreSQL con migraciones.
- Tests unitarios.
- Tests de integracion con Testcontainers.
- Docker Compose.
- CI con GitHub Actions.
- Logs estructurados.
- Correlation ID.
- Metricas con Micrometer.
- Health checks con Actuator.
- Trazas con OpenTelemetry.
- Eventos asincronos.
- Consumidores idempotentes.
- DLQ.
- README profesional.
- Diagramas simples C4.
- ADRs.

## ADRs recomendados

Crear documentos cortos en `docs/adr/`:

- Por que Java 21.
- Por que Spring Boot 3.
- Por que PostgreSQL.
- Por que eventos.
- Por que idempotencia.
- Por que OpenTelemetry.
- Por que esta estrategia de testing.

## README minimo

El README debe explicar:

- objetivo del proyecto,
- arquitectura,
- como ejecutar local,
- servicios,
- endpoints,
- eventos,
- testing,
- observabilidad,
- decisiones tecnicas,
- trade-offs,
- proximos pasos.

## Frase para CV

> Built a production-style Java 21/Spring Boot 3 microservices platform with PostgreSQL, event-driven communication, idempotent consumers, observability, CI/CD and documented architecture decisions.

## Frase para entrevista

> I built this project to update my hands-on stack while leveraging my enterprise banking experience. The focus was not only coding services, but also reliability, observability, testing, deployment and architectural trade-offs.

