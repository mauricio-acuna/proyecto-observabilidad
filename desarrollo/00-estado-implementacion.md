# Estado de implementacion

## Resumen

La carpeta `desarrollo` ya contiene una primera base desarrollable para los 12 proyectos:

- `pom.xml` por proyecto,
- codigo fuente Java/Spring,
- dominio,
- casos de uso,
- puertos/interfaces,
- adaptadores iniciales,
- controllers cuando aplica,
- documentacion de conceptos aplicados,
- ADRs iniciales.

## Validacion ejecutada

Comando ejecutado:

```bash
gradle clean test --console=plain
```

Resultado:

```text
BUILD SUCCESSFUL
66 actionable tasks: 66 executed
```

Cobertura actual:

- 12 proyectos compilados.
- 12 proyectos con al menos un test unitario.
- 23 tests detectados.
- 20 tests ejecutados.
- 3 tests de integracion Testcontainers omitidos porque Docker no esta disponible en este entorno.
- 0 fallos.
- 0 errores.

Nota: Gradle solo pudo ejecutarse fuera del sandbox porque dentro del sandbox fallaba al cargar la libreria nativa de Gradle en Windows.

## Estado por proyecto

| Proyecto | Estado actual | Proximo incremento recomendado |
|---|---|---|
| 01 Plataforma soporte bancario | Dominio, use cases, REST, Prometheus/OTLP tracing, repositorios JPA, migraciones Flyway, outbox persistente, relay RabbitMQ y tests Testcontainers preparados | Ejecutar integracion con Docker |
| 02 Observability control plane | Politicas de telemetria, collector config, Prometheus, Grafana y dashboard inicial | Agregar reglas SLI/SLO y runbooks |
| 03 Event-driven notification hub | Consumidor idempotente, sender desacoplado, Prometheus/OTLP tracing, listener RabbitMQ, retry, DLQ, processed events persistentes, intentos/dead letters auditables, snapshot operativo y metricas Micrometer | Validar flujo completo con Docker |
| 04 Secure API gateway identity | Gateway, security config, correlation id | Agregar Redis rate limiting y Keycloak local |
| 05 FinOps cloud cost guardian | Analisis de costos simulado y recomendaciones | Integrar AWS Cost Explorer con adapter real |
| 06 RAG knowledge assistant | Pipeline RAG conceptual con puertos de vector search y LLM | Agregar pgvector/Qdrant y evaluacion de respuestas |
| 07 Incident response runbook system | Dominio de incidentes y API | Agregar runbooks, postmortems y SLOs |
| 08 Payment risk monitoring | Motor de reglas componibles | Agregar eventos, auditoria persistente y metricas de falsos positivos |
| 09 Batch reporting modernization | Validacion batch y puerto de importacion | Agregar job Spring Batch real con reader/processor/writer |
| 10 Platform engineering service template | Template con CI, Docker, K8s y health | Agregar generador o guia de uso del template |
| 11 Modular monolith to microservices | Modulos internos separados por API | Agregar eventos internos y plan de extraccion |
| 12 AI ticket triage service | Puerto de IA, salida estructurada y fallback rule-based | Agregar proveedor LLM real, WireMock y control de costo |

## Criterio de avance

Para cada proyecto, el orden recomendado es:

1. Completar flujo funcional minimo.
2. Agregar tests de caso de uso.
3. Agregar persistencia o adapter externo real.
4. Agregar observabilidad.
5. Documentar decisiones con ADRs.
6. Preparar explicacion de entrevista.

## Nota de verificacion

Maven no esta disponible en este entorno. La validacion real se hizo con Gradle, usando el build multi-proyecto de la raiz.

El entorno local detectado tiene Java 18. Por eso el build Gradle usa Java 17 como baseline ejecutable localmente. Java 21 queda como objetivo de evolucion y CI.
