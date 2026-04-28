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
| Persistencia y eventos 01 -> 03 | Adapter JPA, Flyway, outbox, relay RabbitMQ y consumer RabbitMQ agregados; falta ejecutar integracion con Docker local | Validar flujo completo con Docker disponible y agregar DLQ/retries |
| Pocos tests por proyecto | Valida solo reglas centrales | Ampliar unit tests, integration tests y controller tests |
| Docker Compose global inicial | Ya existe compose para PostgreSQL, RabbitMQ y OpenTelemetry Collector; faltan servicios de aplicacion | Agregar servicios de aplicacion cuando tengan adapters reales |
| Sin performance ejecutada | No hay baseline de latencia/throughput | Agregar k6/Gatling y escenarios por API |
| Observabilidad parcial | Actuator/config existe, pero falta collector real en todos | Integrar OpenTelemetry collector y dashboards |
| Sin seguridad real en la mayoria | Falta auth en proyectos no-gateway | Propagar OAuth2/JWT desde gateway y tests de seguridad |
| IA simulada | No llama proveedor real | Agregar adapter real y WireMock para pruebas |

## Sprint 1: estabilizacion tecnica

Objetivo:

- Mantener `gradle clean test` en verde.
- Agregar JDK 21.
- Decidir build oficial: Gradle o Maven.
- Docker Compose inicial agregado.
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
- Falta agregar retries y DLQ.
- Integracion logica 01 -> 03 agregada via outbox relay y queue compartida.

Entregables:

- Broker en Docker Compose.
- Consumidor idempotente probado.
- DLQ observable.
- Metricas de procesamiento.

## Sprint 4: observabilidad operativa

Objetivo:

- Integrar OpenTelemetry Collector.
- Agregar dashboards.
- Definir SLI/SLO.

Entregables:

- Collector funcionando.
- Dashboard por servicio.
- Logs correlacionados.
- Runbook de incidente.

## Sprint 5: seguridad y gateway

Objetivo:

- Levantar Keycloak o mock OIDC.
- Agregar rate limiting.
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

- Scripts k6.
- Reporte de latencia p95.
- Plan de tuning.

## Sprint 7: IA aplicada real

Objetivo:

- Reemplazar adapters simulados por proveedor real o mock WireMock.
- Medir costo, tokens y latencia.

Entregables:

- Adapter LLM real.
- Tests con WireMock.
- Metricas de IA.
- Guardrails basicos.
