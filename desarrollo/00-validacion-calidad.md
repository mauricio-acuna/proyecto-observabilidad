# Validacion, calidad y ejecucion

## Estado objetivo

Cada proyecto debe pasar por cuatro niveles de validacion:

1. Compilacion.
2. Tests unitarios de casos de uso.
3. Tests de integracion cuando haya base de datos, broker o proveedor externo.
4. Pruebas operativas: health, metricas, logs, trazas y escenarios de fallo.

## Build local

El repositorio tiene configuracion Gradle multi-proyecto en la raiz.

Comando:

```bash
gradle clean test
```

Reporte de cobertura:

```bash
gradle clean test jacocoTestReport
```

## Estado validado

El comando fue ejecutado correctamente y el resultado fue:

```text
BUILD SUCCESSFUL
68 actionable tasks: 66 executed, 2 up-to-date
```

Tests actuales:

- 29 tests ejecutados.
- 32 tests detectados.
- 3 tests de integracion Testcontainers preparados y omitidos cuando Docker no esta disponible.
- 12 proyectos con compilacion verificada.
- 12 proyectos con al menos un test.
- Tests de integracion reales agregados para persistencia PostgreSQL y outbox del proyecto 01.
- Tests WebFlux agregados para respuestas 401, 403 y 429 del gateway.
- Tests HTTP mockeados agregados para adapter externo y fallback del proyecto 12.
- Tests de metricas agregados para tokens, costo estimado y fallback del proyecto 12.
- Tests de guardrails agregados para redaccion de datos sensibles antes de llamar al proveedor externo del proyecto 12.
- Sin pruebas de performance ejecutadas todavia.

## CI

Workflow:

```text
.github/workflows/desarrollo-ci.yml
```

El CI usa JDK 21 y ejecuta:

```bash
gradle clean test jacocoTestReport --console=plain
docker compose config
```

Tambien publica los reportes JaCoCo como artifact de GitHub Actions.

## Nota sobre Java local

En este entorno se detecto Java 18. Para poder compilar localmente, el build Gradle usa `sourceCompatibility = 17`, compatible con Spring Boot 3 y con el codigo actual.

El objetivo profesional sigue siendo Java 21. Para evolucionar:

1. Instalar JDK 21 local.
2. Cambiar el build Gradle a `JavaVersion.VERSION_21`.
3. Ejecutar `gradle clean test`.

## Performance por tipo de proyecto

| Tipo | Herramienta recomendada |
|---|---|
| APIs REST | k6, Gatling o JMeter |
| Batch | metricas de duracion, throughput y registros rechazados |
| Eventos | lag, retries, DLQ, tiempo de procesamiento |
| IA/RAG | latencia total, latencia retrieval, tokens, costo y tasa de respuestas sin evidencia |
| Observabilidad | cardinalidad, volumen de logs, costo de ingesta |

## Scripts de performance

Se agregaron scripts k6 de referencia:

```text
desarrollo/performance/k6
```

Escenarios disponibles:

- soporte bancario directo o via gateway,
- notification hub,
- gateway con token JWT.

Los scripts se deben ejecutar cuando los servicios esten levantados localmente.

## Infraestructura local

El repositorio incluye un `docker-compose.yml` para levantar dependencias compartidas:

- PostgreSQL en `localhost:5432`.
- RabbitMQ en `localhost:5672` y consola web en `localhost:15672`.
- OpenTelemetry Collector en `localhost:4317` y `localhost:4318`.
- Tempo en `localhost:3200`.
- Prometheus en `localhost:9090`.
- Grafana en `localhost:3000`.

Comando:

```bash
docker compose up -d
```

Tambien incluye un perfil opcional para levantar las aplicaciones principales:

```bash
docker compose --profile apps up --build
```

Servicios de aplicacion:

- `01-plataforma-soporte-bancario` en `localhost:8081`.
- `03-event-driven-notification-hub` en `localhost:8083`.
- `04-secure-api-gateway-identity` en `localhost:8080`.
- `12-ai-ticket-triage-service` en `localhost:8092`.

Prometheus scrapea `/actuator/prometheus` y Grafana provisiona el dashboard `Proyecto2027 Overview`.

Nota: `docker compose config` no pudo ejecutarse en este entorno porque Docker no esta instalado.

## Definition of Done tecnica

Un proyecto se considera presentable cuando tiene:

- README claro.
- Codigo compilando.
- Tests unitarios.
- Al menos un test de integracion si aplica.
- Health endpoint si es servicio.
- Documentacion de conceptos aplicados.
- ADRs.
- Deuda tecnica documentada.
- Siguiente sprint definido.

## Quality gates actuales

Minimo actual:

```bash
gradle clean test
```

Cobertura actual:

- JaCoCo configurado para todos los subproyectos Gradle.
- Cada subproyecto genera reporte HTML y XML en `build/reports/jacoco/test`.

Quality gates propuestos para siguientes sprints:

- agregar Checkstyle o Spotless,
- agregar tests de integracion con Testcontainers,
- agregar k6 para endpoints criticos,
- agregar escaneo de dependencias.
