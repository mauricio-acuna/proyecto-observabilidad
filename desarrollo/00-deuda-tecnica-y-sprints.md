# Deuda tecnica y proximos sprints

## Estado honesto

Los proyectos ya compilan y tienen tests unitarios minimos. Todavia no son productos terminados.

La deuda tecnica actual es deliberada: se priorizo crear una base amplia, compilable y documentada para todos los proyectos antes de profundizar infraestructura real en cada uno.

## Deuda transversal

| Deuda | Impacto | Plan |
|---|---|---|
| Java local 18 y objetivo profesional Java 21 | No permite validar localmente con Java 21 | Instalar JDK 21 y cambiar Gradle a `JavaVersion.VERSION_21` |
| POMs y Gradle conviven | Puede generar confusion | Mantener Gradle como build oficial o alinear POMs en sprint posterior |
| Quality gate de cobertura inicial | JaCoCo ya genera reportes por subproyecto, falta umbral minimo | Definir umbral por modulo cuando aumente la cobertura |
| Persistencia y eventos 01 -> 03 | Adapter JPA, Flyway, outbox, relay RabbitMQ, consumer, retry, DLQ, processed events e intentos persistentes agregados; falta ejecutar integracion con Docker local | Validar flujo completo con Docker disponible y agregar metricas de backlog |
| Pocos tests por proyecto | Valida solo reglas centrales | Ampliar unit tests, integration tests y controller tests |
| Docker Compose global inicial | Ya existe compose para PostgreSQL, RabbitMQ, Redis, Keycloak, OpenTelemetry Collector, Prometheus, Grafana y servicios de aplicacion bajo perfil `apps` | Validar ejecucion local cuando Docker este disponible |
| Sin performance ejecutada | Hay scripts k6 para soporte bancario, notification hub y gateway, pero aun no hay medicion real | Levantar servicios locales y capturar baseline p95 |
| Observabilidad operativa inicial | Servicios 01, 03 y 04 exponen Prometheus, exportan trazas OTLP, y el compose incluye Collector, Tempo, Prometheus, Grafana, reglas SLI/SLO y runbook inicial | Validar con Docker local y agregar correlacion trazas-dashboard |
| Seguridad gateway inicial | Gateway valida JWT, usa issuer OIDC configurable, realm Keycloak versionado, rate limiting Redis y pruebas WebFlux de 401/403/429 | Validar end-to-end con Keycloak y Redis locales |
| IA simulada | Proyecto 12 ya tiene adapter HTTP externo configurable, validacion de salida, fallback rule-based y metricas de provider/tokens/costo | Agregar WireMock y guardrails |

## Sprint 1: estabilizacion tecnica

Objetivo:

- Mantener `gradle clean test` en verde.
- Agregar JDK 21.
- Decidir build oficial: Gradle o Maven.
- Docker Compose inicial agregado con dependencias y perfil `apps`.
- JaCoCo agregado; falta definir umbral minimo.

Entregables:

- Build con Java 21.
- CI en verde.
- Reporte de cobertura.
- Compose minimo con PostgreSQL.

## Sprint 2: persistencia e integracion

Objetivo:

- Reemplazo in-memory en proyecto 01 iniciado con PostgreSQL/Flyway.
- Testcontainers agregado para repositorios del proyecto 01.
- Outbox persistente y relay RabbitMQ agregados.

Entregables:

- Repositorios reales.
- Migraciones.
- Tests de integracion.
- ADR de persistencia.

## Sprint 3: eventos reales

Objetivo:

- Proyecto 03 convertido a consumer RabbitMQ para `ticket.created`.
- Retry y DLQ RabbitMQ agregados.
- Integracion logica 01 -> 03 agregada via outbox relay y queue compartida.

Entregables:

- Broker en Docker Compose.
- Consumidor idempotente probado.
- DLQ observable.
- Metricas de procesamiento.

## Sprint 4: observabilidad operativa

Objetivo:

- Integrar OpenTelemetry Collector.
- Dashboard Grafana inicial agregado.
- SLI/SLO y runbook inicial agregados.

Entregables:

- Collector funcionando.
- Dashboard por servicio.
- Logs correlacionados.
- Runbook de incidente.

## Sprint 5: seguridad y gateway

Objetivo:

- Levantar Keycloak o mock OIDC.
- Keycloak local y realm versionado agregados a Docker Compose.
- Rate limiting Redis agregado.
- Proteger endpoints principales.

Entregables:

- Gateway funcional.
- JWT validado.
- Tests de 401/403/429.
- ADR de seguridad.

## Sprint 6: performance

Objetivo:

- Crear baseline de rendimiento.
- Medir endpoints criticos.
- Documentar cuellos de botella.

Entregables:

- Scripts k6 para APIs criticas.
- Reporte de latencia p95.
- Plan de tuning.

## Sprint 7: IA aplicada real

Objetivo:

- Completar adapters IA con proveedor HTTP configurable y mock WireMock.
- Medir costo, tokens y latencia.

Entregables:

- Adapter LLM HTTP configurable.
- Tests de contrato con WireMock.
- Metricas de IA.
- Guardrails basicos.
