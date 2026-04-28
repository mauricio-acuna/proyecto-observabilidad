# Lineamientos para seguir trabajando

## Estado actual

La base ya existe y esta validada:

- 12 proyectos en `desarrollo`.
- 12 proyectos compilan.
- 12 proyectos tienen tests unitarios minimos.
- 14 tests ejecutados.
- `gradle clean test --console=plain` paso correctamente.
- Dashboard visible en `desarrollo/dashboard/index.html`.
- CI inicial en `.github/workflows/desarrollo-ci.yml`.

## Regla principal

No avanzar en features si:

- el build esta roto,
- los tests fallan,
- la documentacion no refleja el cambio,
- la deuda tecnica no esta registrada,
- no se puede explicar que concepto profesional demuestra el cambio.

## Proximo sprint vigente

El siguiente trabajo debe seguir el orden del plan de entrega.

### Sprint 1 - Estabilizacion tecnica

Objetivo:

Convertir la base compilable en plataforma robusta.

Tareas:

- Verificar o instalar JDK 21.
- Migrar Gradle a Java 21 cuando el entorno lo permita.
- Mantener `gradle clean test --console=plain` en verde.
- Agregar JaCoCo.
- Agregar Spotless o Checkstyle.
- Resolver warnings/deprecations de Gradle si corresponden.
- Definir Gradle como build oficial o alinear los POMs.
- Crear primer Docker Compose minimo.
- Actualizar dashboard y documentos de estado.

Criterio de aceptacion:

- Build verde.
- Tests verdes.
- CI listo.
- Reporte de cobertura disponible.
- Deuda tecnica actualizada.

## Orden despues del Sprint 1

### Sprint 2 - Persistencia real

Proyecto principal:

`desarrollo/01-plataforma-soporte-bancario`

Tareas:

- PostgreSQL.
- Flyway.
- Repositorios reales.
- Testcontainers.
- Migraciones.
- Tests de integracion.
- Modelo de datos documentado.
- Outbox persistente como siguiente paso.

### Sprint 3 - Eventos reales

Proyectos:

- `01-plataforma-soporte-bancario`
- `03-event-driven-notification-hub`

Tareas:

- Broker local.
- Outbox.
- Consumidor idempotente.
- Retries.
- DLQ.
- Metricas de procesamiento.
- Test de duplicados.
- Test de fallo.

### Sprint 4 - Observabilidad end-to-end

Proyectos:

- `02-observability-control-plane`
- `01-plataforma-soporte-bancario`
- `03-event-driven-notification-hub`

Tareas:

- OpenTelemetry Collector.
- Logs estructurados.
- Trace ID.
- Span ID.
- Dashboards.
- SLI/SLO.
- Runbooks.

### Sprint 5 - Seguridad y gateway

Proyecto:

`04-secure-api-gateway-identity`

Tareas:

- Keycloak o mock OIDC.
- JWT.
- Roles.
- Rate limiting.
- Tests 401/403/429.
- Auditoria de acceso.

### Sprint 6 - Performance y resiliencia

Tareas:

- Ejecutar k6.
- Registrar p95.
- Registrar error rate.
- Agregar Resilience4j.
- Timeouts.
- Circuit breakers.
- Reporte de performance.

### Sprint 7 - IA aplicada real

Proyectos:

- `06-rag-knowledge-assistant`
- `12-ai-ticket-triage-service`

Tareas:

- Adapter LLM real o WireMock contractual.
- Prompt versioning.
- Structured outputs.
- pgvector o Qdrant.
- Metricas de tokens, costo y latencia.
- Guardrails basicos.
- Tests de respuestas sin evidencia.

### Sprint 8 - Cierre portfolio

Tareas:

- READMEs finales.
- Diagramas.
- Dashboard actualizado.
- Historias de entrevista.
- Scripts de demo.
- Estado final de deuda.
- Guia para explicar cada proyecto en entrevistas.

## Definition of Done por cambio

Cada incremento debe incluir:

- codigo,
- tests,
- documentacion,
- ADR si hay decision importante,
- deuda tecnica si queda algo pendiente,
- ejecucion de `gradle clean test --console=plain`,
- actualizacion del dashboard si cambia el estado.

## Fuentes maestras

Leer siempre:

- `Proyecto2027/13-instrucciones-ia-director-area.md`
- `Proyecto2027/14-plan-entrega-calidad.md`
- `Proyecto2027/15-prompts-operativos-ia.md`
- `desarrollo/00-estado-implementacion.md`
- `desarrollo/00-validacion-calidad.md`
- `desarrollo/00-deuda-tecnica-y-sprints.md`

