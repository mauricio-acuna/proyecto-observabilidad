# FinOps Cloud Cost Guardian

## Problema real que resuelve

Muchos equipos cloud despliegan servicios sin visibilidad clara de costos. En roles senior, saber hablar de costo, capacidad y trade-offs diferencia mucho el perfil.

Este proyecto analiza costos cloud y genera recomendaciones simples.

## Capacidades funcionales

- Ingesta de datos de costos simulados o AWS Cost Explorer.
- Clasificacion por servicio/equipo/entorno.
- Deteccion de gasto anomalo.
- Recomendaciones de right sizing.
- Alertas de presupuesto.
- Reporte semanal.

## Stack aplicado

- Java 21.
- Spring Boot 3.
- AWS Cost Explorer.
- AWS Budgets.
- CloudWatch.
- PostgreSQL.
- Scheduler.
- OpenAPI.
- Micrometer.
- Testcontainers.
- WireMock para simular AWS.

## Patrones y soluciones

- Scheduled jobs.
- Integracion con APIs externas.
- Retry/backoff.
- Circuit breaker.
- Caching.
- Separacion entre datos crudos y agregados.
- Metricas de negocio.
- FinOps basico.

## Diseno sugerido

Modulos:

- `cost-ingestion`
- `cost-analysis`
- `recommendation-engine`
- `budget-alerts`
- `report-api`

## Que se puede defender en entrevista

- Por que costo tambien es una decision de arquitectura.
- Como evitar sobreaprovisionamiento.
- Como disenar alertas que no generen ruido.
- Como manejar fallos de APIs externas.
- Como estimar costo de una arquitectura.

## Entregables

- API de reportes.
- Job de ingesta.
- Reglas de recomendacion.
- Dashboard de costos.
- Tests con datos simulados.
- ADR sobre control de costos.

