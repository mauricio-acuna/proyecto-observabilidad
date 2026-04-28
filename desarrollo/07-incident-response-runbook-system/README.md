# Incident Response & Runbook System

## Problema real que resuelve

Cuando ocurre un incidente, muchos equipos dependen de conocimiento informal. Este proyecto centraliza incidentes, postmortems, runbooks y SLOs para mejorar respuesta operativa.

## Capacidades funcionales

- Registro de incidentes.
- Clasificacion por severidad.
- Timeline de acciones.
- Runbooks por servicio.
- Postmortems blameless.
- Asociacion con SLOs.
- Acciones correctivas.
- Reporte mensual de confiabilidad.

## Stack aplicado

- Java 21.
- Spring Boot 3.
- PostgreSQL.
- OpenAPI.
- Micrometer.
- Actuator.
- OpenTelemetry.
- Docker Compose.
- Testcontainers.

## Patrones y soluciones

- SLI/SLO.
- Incident management.
- Blameless postmortem.
- Error budget conceptual.
- Audit trail.
- State machine simple.
- Domain events.
- Logs estructurados.

## Diseno sugerido

Entidades:

- `Incident`
- `Service`
- `Runbook`
- `Postmortem`
- `CorrectiveAction`
- `Slo`

Estados:

- Open.
- Investigating.
- Mitigated.
- Resolved.
- Reviewed.

## Que se puede defender en entrevista

- Como se opera un sistema vivo.
- Como reducir MTTR.
- Que diferencia hay entre alerta util y ruido.
- Como conectar observabilidad con accion.
- Como escribir postmortems sin culpar personas.

## Entregables

- API de incidentes.
- Modelo de SLO.
- Plantillas de runbook.
- Ejemplos de postmortem.
- Dashboard de incidentes.
- ADR sobre gestion operativa.

