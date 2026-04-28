# Plan de entrega con calidad

## Resumen

Este plan convierte la cartera `desarrollo` en un programa de entrega incremental.

Fecha objetivo inicial:

**31 de enero de 2027**

## Hitos

| Hito | Resultado esperado |
|---|---|
| H0 | Build multi-proyecto estable y dashboard visible |
| H1 | Proyecto principal con persistencia real e integracion |
| H2 | Eventos reales, DLQ e idempotencia demostrable |
| H3 | Observabilidad end-to-end con collector y dashboards |
| H4 | Gateway seguro con OAuth2/OIDC, JWT y rate limiting |
| H5 | Performance baseline y quality gates |
| H6 | IA aplicada con RAG y triage validados |
| H7 | Portfolio final documentado y listo para entrevistas |

## Sprint 1 - Estabilizacion tecnica

### Objetivo

Convertir la base compilable en plataforma de trabajo robusta.

### Alcance

- Instalar/usar JDK 21.
- Cambiar Gradle a Java 21.
- Mantener `gradle clean test` en verde.
- Agregar JaCoCo.
- Agregar Spotless o Checkstyle.
- Resolver warning de Gradle deprecations si corresponde.
- Definir Gradle como build oficial o alinear Maven.

### Entregables

- Build Java 21.
- CI verde.
- Reporte de cobertura.
- Documento de build oficial.

### Criterio de aceptacion

- `gradle clean test` pasa.
- CI pasa.
- Dashboard actualizado.

## Sprint 2 - Persistencia real en proyecto principal

### Objetivo

Hacer que `01-plataforma-soporte-bancario` deje de depender de memoria.

### Alcance

- PostgreSQL.
- Flyway.
- Repositorios reales.
- Testcontainers.
- Migraciones.
- Tests de integracion.
- Documentacion de modelo de datos.

### Entregables

- `docker-compose.yml` con PostgreSQL.
- Migraciones SQL.
- Integration tests.
- ADR de persistencia.

### Criterio de aceptacion

- Tests unitarios e integracion pasan.
- El servicio permite crear customer y ticket contra DB real.

## Sprint 3 - Eventos reales

### Objetivo

Convertir eventos simulados en flujo robusto.

### Alcance

- Broker: RabbitMQ, Kafka o SQS local/simulado.
- Outbox persistente.
- Consumidor idempotente.
- Retries.
- DLQ.
- Metricas de procesamiento.

### Entregables

- Integracion proyecto 01 -> proyecto 03.
- Test de duplicado.
- Test de fallo y DLQ.
- ADR de broker.

### Criterio de aceptacion

- Evento `TicketCreated` llega a notification hub.
- Duplicados no generan doble envio.
- Fallos se registran en DLQ.

## Sprint 4 - Observabilidad end-to-end

### Objetivo

Demostrar observabilidad real, no decorativa.

### Alcance

- OpenTelemetry Collector.
- Logs estructurados.
- Trace ID y span ID.
- Dashboard basico.
- SLI/SLO.
- Runbook de incidente.

### Entregables

- Compose con collector.
- Dashboard exportado.
- Runbook.
- Docs de cardinalidad y sampling.

### Criterio de aceptacion

- Una request puede seguirse por logs y trazas.
- Hay metricas de latencia, errores y throughput.

## Sprint 5 - Seguridad y gateway

### Objetivo

Proteger APIs como sistema enterprise.

### Alcance

- Keycloak o mock OIDC.
- Validacion JWT.
- Roles.
- Rate limiting.
- Tests 401/403/429.
- Auditoria de acceso.

### Entregables

- Gateway funcional.
- Config local.
- Tests de seguridad.
- ADR de seguridad.

### Criterio de aceptacion

- Rutas privadas rechazan requests sin token.
- Rate limiting responde 429.
- Correlation ID se propaga.

## Sprint 6 - Performance y resiliencia

### Objetivo

Tener datos de rendimiento y fallos.

### Alcance

- k6 para endpoints criticos.
- Baseline p95.
- Resilience4j.
- Timeouts.
- Circuit breakers.
- Reporte de performance.

### Entregables

- Scripts k6.
- Reporte baseline.
- ADR de resiliencia.

### Criterio de aceptacion

- Se conoce p95 local.
- Hay umbrales documentados.
- Fallos externos no tumban el flujo principal.

## Sprint 7 - IA aplicada real

### Objetivo

Demostrar IA aplicada como backend confiable.

### Alcance

- Adapter LLM real o WireMock contractual.
- Prompt versioning.
- Structured outputs.
- RAG con pgvector/Qdrant.
- Metricas de tokens, costo y latencia.
- Guardrails basicos.

### Entregables

- RAG funcional.
- AI triage funcional.
- Tests con WireMock.
- Evaluacion basica.

### Criterio de aceptacion

- El sistema rechaza respuestas sin evidencia.
- La salida IA se valida como contrato.
- Costo/latencia quedan medidos.

## Sprint 8 - Cierre portfolio

### Objetivo

Preparar todo para presentacion profesional.

### Alcance

- READMEs finales.
- Diagramas.
- Dashboard actualizado.
- Historias de entrevista.
- Scripts de demo.
- Estado final de deuda.

### Entregables

- Portfolio navegable.
- Demo script.
- Presentacion ejecutiva.
- Preguntas/respuestas de entrevista.

### Criterio de aceptacion

- Se puede explicar cada proyecto en 3 minutos.
- Se puede profundizar tecnicamente en 15 minutos.
- Todo lo afirmado tiene evidencia en codigo, tests o documentacion.

