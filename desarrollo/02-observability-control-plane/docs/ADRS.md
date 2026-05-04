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
Prometheus, Tempo y Grafana se provisionan desde `docker-compose.yml`.

### Motivo

Prometheus encaja bien con metricas por pull y alertado. OTLP mantiene trazas desacopladas del backend final y permite cambiar de Tempo a Jaeger/Cloud sin tocar los servicios.

### Consecuencias

- Los servicios deben tener puertos distintos cuando corren en local.
- El dashboard se versiona con el repositorio.
- Tempo conserva trazas locales por 24 horas para diagnostico y demos.

## ADR-004: Definir SLI/SLO y alertas accionables

### Decision

Agregar reglas Prometheus para error rate, latencia HTTP y dead letters del notification hub.
Documentar el runbook asociado en `docs/SLI-SLO-RUNBOOK.md`.

### Motivo

Una alerta util debe indicar una condicion observable y una accion esperada. Sin runbook, el dashboard solo muestra sintomas.

### Consecuencias

- El proyecto puede defender criterios iniciales de operacion y respuesta.
- Las alertas son simples y locales; deben calibrarse con datos reales de performance.
- Falta integrar Alertmanager o un canal de notificacion real.
