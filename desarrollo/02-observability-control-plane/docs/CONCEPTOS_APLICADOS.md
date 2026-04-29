# Conceptos aplicados

## Observabilidad como plataforma

El proyecto no instala una herramienta aislada: define politicas comunes que los servicios deben cumplir.

## Logs estructurados

`requiredLogFields` exige `traceId` y `spanId` para correlacion entre logs y trazas.

## Metricas y cardinalidad

`maxAllowedMetricCardinality` permite explicar por que una etiqueta mal elegida puede disparar costos y degradar consultas.

## OpenTelemetry Collector

`otel-collector-config.yml` muestra la pieza que desacopla aplicaciones de backends finales.

## Prometheus y Grafana

Prometheus scrapea las metricas Actuator de los servicios principales y Grafana provisiona un dashboard inicial desde el repositorio.
Esto permite demostrar una ruta completa desde codigo instrumentado hasta visualizacion operativa.

## SLI/SLO

Se agregaron SLIs/SLOs iniciales para error rate, latencia HTTP y dead letters.
Las reglas Prometheus y el runbook permiten explicar como pasar de "tengo metricas" a "se que accion tomar".

## Conceptos del perfil que cubre

- OpenTelemetry.
- Micrometer.
- Actuator.
- Collector.
- Correlacion.
- Cardinalidad.
- Estandares internos.
- Platform Engineering inicial.
