# Conceptos aplicados

## Observabilidad como plataforma

El proyecto no instala una herramienta aislada: define politicas comunes que los servicios deben cumplir.

## Logs estructurados

`requiredLogFields` exige `traceId` y `spanId` para correlacion entre logs y trazas.

## Metricas y cardinalidad

`maxAllowedMetricCardinality` permite explicar por que una etiqueta mal elegida puede disparar costos y degradar consultas.

## OpenTelemetry Collector

`otel-collector-config.yml` muestra la pieza que desacopla aplicaciones de backends finales.

## SLI/SLO

La siguiente evolucion del proyecto es asociar cada servicio a SLI/SLO y reglas de alerta.

## Conceptos del perfil que cubre

- OpenTelemetry.
- Micrometer.
- Actuator.
- Collector.
- Correlacion.
- Cardinalidad.
- Estandares internos.
- Platform Engineering inicial.

