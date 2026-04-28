# ADRs iniciales

## ADR-001: Definir politicas de telemetria por servicio

### Decision

Cada servicio registra una politica de telemetria con campos minimos de logs, tags de metricas y requisito de tracing.

### Motivo

Sin estandares, la observabilidad escala mal y se vuelve dificil comparar servicios.

## ADR-002: Usar OpenTelemetry Collector

### Decision

Enviar telemetria a un collector antes del backend final.

### Motivo

Permite filtrar, muestrear, transformar y enrutar sin acoplar las aplicaciones a un vendor.

