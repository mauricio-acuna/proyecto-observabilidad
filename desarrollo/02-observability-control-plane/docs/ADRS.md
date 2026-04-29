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

## ADR-003: Separar metricas pull y trazas push

### Decision

Los servicios exponen metricas Prometheus por `/actuator/prometheus` y exportan trazas por OTLP HTTP hacia el OpenTelemetry Collector.
Prometheus y Grafana se provisionan desde `docker-compose.yml`.

### Motivo

Prometheus encaja bien con metricas por pull y alertado. OTLP mantiene trazas desacopladas del backend final y permite cambiar de debug exporter a Tempo/Jaeger/Cloud sin tocar los servicios.

### Consecuencias

- Los servicios deben tener puertos distintos cuando corren en local.
- El dashboard se versiona con el repositorio.
- Falta agregar reglas SLI/SLO y un backend persistente de trazas.
