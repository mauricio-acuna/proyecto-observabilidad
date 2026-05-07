# FinOps Cloud Cost Guardian

## Problema real que resuelve

Muchos equipos cloud despliegan servicios sin visibilidad clara de costos. En roles senior, saber hablar de costo, capacidad y trade-offs diferencia mucho el perfil.

Este proyecto analiza costos cloud y genera recomendaciones simples.

## Capacidades funcionales

- Ingesta de datos de costos simulados o AWS Cost Explorer.
- Provider HTTP configurable compatible con un facade interno de Cost Explorer.
- Clasificacion por servicio/equipo/entorno.
- Deteccion de gasto anomalo.
- Recomendaciones de right sizing.
- Metricas de gasto analizado, recomendaciones y ahorro estimado.
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

## Configuracion local actual

Por defecto usa datos simulados:

```bash
APP_FINOPS_PROVIDER=simulated
```

Para activar el provider HTTP:

```bash
APP_FINOPS_PROVIDER=aws-http
APP_FINOPS_AWS_BASE_URL=http://localhost:8095
APP_FINOPS_AWS_API_KEY=dev-token
```

El adapter llama `GET /cost-explorer/costs?from=YYYY-MM-DD&to=YYYY-MM-DD`.
Si la API externa falla o devuelve una lista vacia, el sistema usa el provider simulado como fallback.

Metricas publicadas:

- `finops_cost_records_analyzed_total`
- `finops_cost_analyzed_usd_total`
- `finops_recommendations_total`
- `finops_recommendations_by_severity_total`
- `finops_estimated_savings_usd_total`

Endpoint de alertas de presupuesto:

```text
GET /api/costs/budget-alerts?from=2026-05-01&to=2026-05-31
```

El umbral mensual por defecto se configura con:

```bash
APP_FINOPS_DEFAULT_MONTHLY_BUDGET_USD=1000
```

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
- Metricas financieras Micrometer.
- Alertas de presupuesto por servicio y ambiente.
- Tests con datos simulados y provider HTTP mockeado.
- ADR sobre control de costos.
