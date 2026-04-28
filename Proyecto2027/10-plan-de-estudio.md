# Plan de estudio

## Principio

Estudiar solo lo que alimenta el objetivo profesional. El orden importa mas que la cantidad.

## Nivel 1: base obligatoria

### Java 17/21

Debe dominar:

- records,
- pattern matching,
- sealed classes,
- mejoras de concurrencia,
- virtual threads a nivel conceptual y practico basico,
- performance y memoria a nivel senior.

Profundidad necesaria: alta.

### Spring Boot 3

Debe dominar:

- autoconfiguracion,
- profiles,
- configuracion externa,
- Actuator,
- validation,
- exception handling,
- testing,
- observabilidad,
- empaquetado.

Profundidad necesaria: alta.

### APIs REST

Debe dominar:

- codigos HTTP,
- idempotencia,
- paginacion,
- versionado,
- errores consistentes,
- OpenAPI,
- seguridad.

Profundidad necesaria: alta.

### PostgreSQL

Debe dominar:

- modelado,
- indices,
- transacciones,
- locks basicos,
- queries,
- JPA con criterio,
- cuando usar SQL directo.

Profundidad necesaria: alta.

## Nivel 2: ingenieria productiva

### Testing

Debe dominar:

- JUnit 5,
- Mockito,
- AssertJ,
- Testcontainers,
- tests de integracion,
- pruebas de endpoints,
- pruebas de repositorios,
- WireMock para dependencias externas.

Profundidad necesaria: alta.

### Observabilidad

Debe dominar:

- logs estructurados,
- metricas,
- trazas,
- correlation id,
- Micrometer,
- Actuator,
- OpenTelemetry,
- cardinalidad,
- SLI/SLO,
- alertas accionables.

Profundidad necesaria: alta.

### Docker y CI/CD

Debe dominar:

- multi-stage builds,
- variables de entorno,
- Docker Compose,
- pipelines,
- test/build/package,
- rollback conceptual.

Profundidad necesaria: media-alta.

## Nivel 3: cloud y arquitectura

### AWS

Prioridad:

- IAM,
- ECS/Fargate,
- RDS,
- SQS/SNS,
- CloudWatch,
- Secrets Manager,
- Cost Explorer,
- Budgets.

Profundidad necesaria: media-alta.

### Mensajeria

Debe dominar:

- queues,
- pub/sub,
- retries,
- backoff,
- DLQ,
- idempotencia,
- outbox pattern,
- eventual consistency.

Profundidad necesaria: alta para entrevistas senior.

### Kubernetes

Debe conocer:

- pods,
- deployments,
- services,
- configmaps/secrets,
- probes,
- ingress,
- escalado basico.

Profundidad necesaria: media.

## Nivel 4: complementos

### Platform Engineering y GitOps

Debe poder explicar:

- que problema resuelven,
- cuando aparecen,
- como cambian el flujo de trabajo,
- Argo CD/Flux a nivel conceptual.

Profundidad necesaria: conceptual.

### Spring Modulith

Util para hablar de modularidad antes de microservicios.

Profundidad necesaria: conceptual/practica ligera.

### GraalVM

Util en serverless/startup/memoria, no baseline.

Profundidad necesaria: conceptual.

### Spring AI

Util si se construye el proyecto IA.

Profundidad necesaria: practica acotada.

## Temas a no priorizar

- Service mesh avanzado.
- Event sourcing por moda.
- ML engineering.
- Mobile.
- IoT.
- Cursos teoricos largos sin proyecto.
- Comparativas infinitas de frameworks.

