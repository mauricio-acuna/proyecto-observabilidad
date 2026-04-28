# Performance

## Objetivo

Definir pruebas de rendimiento simples y defendibles para los proyectos mas orientados a API.

## Herramienta recomendada

`k6` para smoke/performance inicial.

## Script disponible

```text
k6/plataforma-soporte-bancario-smoke.js
```

## Ejecucion

Con `01-plataforma-soporte-bancario` levantado en `localhost:8080`:

```bash
k6 run desarrollo/performance/k6/plataforma-soporte-bancario-smoke.js
```

## Metricas objetivo iniciales

- Error rate menor a 1%.
- Latencia p95 menor a 500 ms en entorno local.
- Correlation ID presente en requests.

## Deuda

Todavia no se ejecuto k6 en este entorno. Queda como tarea del sprint de performance cuando los servicios se ejecuten localmente.
