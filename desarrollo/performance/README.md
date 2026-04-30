# Performance

## Objetivo

Definir pruebas de rendimiento simples y defendibles para los proyectos mas orientados a API.

## Herramienta recomendada

`k6` para smoke/performance inicial.

## Scripts disponibles

```text
k6/plataforma-soporte-bancario-smoke.js
k6/notification-hub-smoke.js
k6/gateway-support-smoke.js
```

## Ejecucion

Con `01-plataforma-soporte-bancario` levantado en `localhost:8081`:

```bash
k6 run desarrollo/performance/k6/plataforma-soporte-bancario-smoke.js
```

Con `03-event-driven-notification-hub` levantado en `localhost:8083`:

```bash
k6 run desarrollo/performance/k6/notification-hub-smoke.js
```

Con el gateway en `localhost:8080`, Keycloak/Redis levantados y un token con rol `support_user`:

```bash
k6 run -e TOKEN=<access-token> desarrollo/performance/k6/gateway-support-smoke.js
```

Tambien se puede cambiar el destino sin editar scripts:

```bash
k6 run -e BASE_URL=http://localhost:8080 -e PATH_PREFIX=/support -e TOKEN=<access-token> desarrollo/performance/k6/plataforma-soporte-bancario-smoke.js
```

## Metricas objetivo iniciales

- Error rate menor a 1%.
- Latencia p95 menor a 500 ms en entorno local.
- Correlation ID presente en requests.
- Gateway con p95 menor a 800 ms en entorno local.

## Deuda

Todavia no se ejecuto k6 en este entorno. Queda como tarea del sprint de performance cuando los servicios se ejecuten localmente.
