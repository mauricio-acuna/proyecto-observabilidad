# SLI, SLO y runbook operativo

## Servicios cubiertos

- `plataforma-soporte-bancario`
- `event-driven-notification-hub`

## SLIs iniciales

| SLI | Fuente | Consulta base |
|---|---|---|
| Disponibilidad HTTP | Prometheus / Actuator | `rate(http_server_requests_seconds_count{status!~"5.."}[5m]) / rate(http_server_requests_seconds_count[5m])` |
| Latencia HTTP promedio | Prometheus / Actuator | `rate(http_server_requests_seconds_sum[5m]) / rate(http_server_requests_seconds_count[5m])` |
| Dead letters de notificaciones | Micrometer custom | `notification_hub_dead_letter_events_total` |

## SLOs iniciales

| SLO | Objetivo |
|---|---|
| Error rate HTTP | Menos de 5% de respuestas 5xx durante 5 minutos |
| Latencia HTTP promedio | Menos de 750 ms durante 10 minutos |
| Dead letters | 0 eventos en DLQ persistidos |

## Alertas

Las reglas estan versionadas en:

```text
desarrollo/02-observability-control-plane/prometheus/rules/proyecto2027-alerts.yml
```

Alertas iniciales:

- `Proyecto2027HighHttpErrorRate`
- `Proyecto2027HighHttpLatency`
- `Proyecto2027NotificationDeadLetters`

## Runbook: dead letters en notification hub

1. Revisar snapshot operativo:

```bash
curl http://localhost:8083/api/notifications/operations/snapshot
```

2. Revisar cola DLQ en RabbitMQ:

```text
http://localhost:15672
```

3. Consultar eventos persistidos en PostgreSQL:

```sql
select id, queue_name, failure_reason, received_at
from dead_letter_events
order by received_at desc;
```

4. Revisar si el payload falla por contrato, datos incompletos o error temporal del sender.

5. Si el problema es temporal, reinyectar el payload corregido en `support.events` con routing key `ticket.created`.

## Runbook: latencia HTTP alta

1. Verificar panel `HTTP average latency` en Grafana.
2. Comparar latencia con throughput para distinguir carga alta de bloqueo.
3. Revisar logs correlacionados por `traceId`.
4. Revisar PostgreSQL y RabbitMQ si el flujo afectado crea tickets o procesa eventos.
5. Si la latencia se concentra en endpoints de escritura, revisar outbox y disponibilidad del broker.

## Runbook: error rate HTTP alto

1. Identificar servicio afectado en Prometheus/Grafana.
2. Revisar logs por `traceId` y status 5xx.
3. Confirmar estado de dependencias locales: PostgreSQL, RabbitMQ y collector.
4. Validar si el error coincide con migraciones, credenciales o puertos ocupados.
5. Crear incidente si el error rate se mantiene mas de 15 minutos.
