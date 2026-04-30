# Observability Control Plane

## Problema real que resuelve

En equipos con varios microservicios, cada servicio suele emitir logs, metricas y trazas de forma distinta. Eso vuelve dificil diagnosticar incidentes, controlar costos y comparar comportamiento entre servicios.

Este proyecto crea un estandar interno de observabilidad para servicios Spring Boot.

## Capacidades funcionales

- Libreria o starter comun para servicios Spring Boot.
- Configuracion estandar de logs estructurados.
- Propagacion de correlation ID.
- Exposicion consistente de metricas.
- Trazas con OpenTelemetry.
- Plantillas de dashboards.
- Reglas basicas de alertado.
- Guia de cardinalidad.

## Stack aplicado

- Java 21.
- Spring Boot 3.
- Spring Boot Actuator.
- Micrometer.
- OpenTelemetry Java Agent/SDK.
- OTLP.
- OpenTelemetry Collector.
- Prometheus.
- Grafana.
- Loki o Elastic para logs.
- Jaeger/Tempo para trazas.

## Patrones y soluciones

- Observabilidad como capacidad de plataforma.
- Convenciones internas.
- Logs estructurados.
- Metricas tecnicas y de negocio.
- Trazas distribuidas.
- Sampling.
- Control de cardinalidad.
- SLI/SLO basicos.
- Dashboards reutilizables.
- Alertas accionables.

## Diseno sugerido

Componentes:

- `observability-spring-starter`
- `otel-collector-config`
- `grafana-dashboards`
- `alerting-rules`
- `observability-guidelines.md`

## Que se puede defender en entrevista

- Diferencia entre tener dashboards y tener observabilidad real.
- Por que OpenTelemetry reduce lock-in.
- Como correlacionar logs, metricas y trazas.
- Por que la cardinalidad puede disparar costos.
- Como definir SLI/SLO basicos.
- Como reducir MTTR.

## Entregables

- Starter reutilizable.
- Configuracion de collector.
- Dashboard por servicio.
- Dashboard de sistema.
- Guia de instrumentacion.
- Ejemplo aplicado sobre la plataforma de soporte bancario.

## Implementacion actual

El repositorio incluye una primera ruta operativa de observabilidad local:

- OpenTelemetry Collector en `localhost:4317` y `localhost:4318`.
- Prometheus en `localhost:9090`.
- Grafana en `localhost:3000`.
- Datasource Prometheus provisionado automaticamente.
- Dashboard `Proyecto2027 Overview` versionado en `grafana/dashboards`.
- Reglas de alerta Prometheus en `prometheus/rules`.
- Runbook inicial en `docs/SLI-SLO-RUNBOOK.md`.

Servicios instrumentados inicialmente:

- `01-plataforma-soporte-bancario` en `localhost:8081`.
- `03-event-driven-notification-hub` en `localhost:8083`.
- `04-secure-api-gateway-identity` en `localhost:8080`.

Los servicios exponen metricas en `/actuator/prometheus` y exportan trazas por OTLP HTTP al collector.
Prometheus esta preparado para scrapear servicios ejecutados en el host y servicios levantados dentro de `docker compose --profile apps`.
