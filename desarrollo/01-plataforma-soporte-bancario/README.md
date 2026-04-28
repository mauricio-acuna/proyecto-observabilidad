# Plataforma de soporte bancario

## Problema real que resuelve

Un banco o fintech necesita centralizar la gestion de clientes, tickets de soporte, auditoria y notificaciones internas. El sistema debe ser confiable, trazable, testeable y facil de operar.

Este proyecto sirve como proyecto principal de portfolio porque permite demostrar backend moderno de punta a punta.

## Capacidades funcionales

- Alta y consulta de clientes.
- Creacion y seguimiento de tickets.
- Cambio de estado de tickets.
- Auditoria de acciones relevantes.
- Publicacion de eventos de negocio.
- Notificacion asincrona.
- Consulta de historial por cliente.

## Stack aplicado

- Java 21.
- Spring Boot 3.
- Spring Web.
- Spring Validation.
- Spring Data JPA.
- PostgreSQL.
- Flyway.
- OpenAPI/Swagger.
- Docker Compose.
- JUnit 5.
- Mockito.
- Testcontainers.
- GitHub Actions.
- Micrometer.
- Actuator.
- OpenTelemetry.
- Prometheus/Grafana o CloudWatch.

## Patrones y soluciones

- Arquitectura por servicios.
- Layered architecture.
- DTOs y validacion de entrada.
- Manejo global de errores.
- Correlation ID.
- Outbox pattern para publicar eventos.
- Consumidores idempotentes.
- Retries y DLQ.
- Health checks.
- Logs estructurados.
- Metricas de negocio.
- Trazas distribuidas.

## Diseno sugerido

Servicios:

- `customer-service`
- `ticket-service`
- `notification-service`
- `audit-service`

Base de datos:

- PostgreSQL por servicio o esquemas separados para simplificar.

Eventos:

- `TicketCreated`
- `TicketStatusChanged`
- `CustomerUpdated`
- `NotificationRequested`

## Que se puede defender en entrevista

- Por que no meter todo en un CRUD monolitico.
- Como garantizar idempotencia en consumidores.
- Como diagnosticar un ticket lento usando logs, metricas y trazas.
- Como evitar que una caida de notificaciones bloquee la creacion del ticket.
- Como probar integraciones con Testcontainers.
- Como documentar decisiones con ADRs.

## Entregables

- Repositorio ejecutable localmente.
- README profesional.
- Diagrama C4.
- ADRs.
- Coleccion de requests.
- Pipeline CI.
- Dashboard basico.
- Runbook de incidente.

