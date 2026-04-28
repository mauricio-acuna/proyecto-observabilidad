# Desarrollo

Esta carpeta contiene una cartera de proyectos reales pensados para demostrar el stack completo del perfil 2027.

No son ejercicios aislados. Cada proyecto existe para poder explicar en entrevistas:

- que problema real resuelve,
- que decisiones tecnicas se tomaron,
- que patrones se aplicaron,
- como se probo,
- como se opera,
- como se observa,
- que trade-offs hubo.

## Proyectos

0. [00-guia-implementacion.md](00-guia-implementacion.md)  
   Criterio tecnico comun para desarrollar cada proyecto.

0. [00-estado-implementacion.md](00-estado-implementacion.md)  
   Estado actual de implementacion y proximo incremento recomendado.

0. [00-validacion-calidad.md](00-validacion-calidad.md)  
   Build, tests, CI, quality gates y performance.

0. [00-deuda-tecnica-y-sprints.md](00-deuda-tecnica-y-sprints.md)  
   Deuda tecnica actual y plan de trabajo por sprints.

0. [dashboard/index.html](dashboard/index.html)  
   Dashboard visual del estado actual, indicadores, dolores y roadmap.

0. [../Proyecto2027/13-instrucciones-ia-director-area.md](../Proyecto2027/13-instrucciones-ia-director-area.md)  
   Mandato de direccion para que una IA continue el programa con calidad.

0. [../Proyecto2027/14-plan-entrega-calidad.md](../Proyecto2027/14-plan-entrega-calidad.md)  
   Plan de entrega por sprints, hitos y criterios de aceptacion.

0. [../Proyecto2027/15-prompts-operativos-ia.md](../Proyecto2027/15-prompts-operativos-ia.md)  
   Prompts listos para delegar sprints completos a una IA.

1. [01-plataforma-soporte-bancario](01-plataforma-soporte-bancario/README.md)  
   Plataforma principal de microservicios Java para soporte bancario.

2. [02-observability-control-plane](02-observability-control-plane/README.md)  
   Estandar interno de observabilidad para servicios Spring Boot.

3. [03-event-driven-notification-hub](03-event-driven-notification-hub/README.md)  
   Hub de eventos, notificaciones, retries, DLQ e idempotencia.

4. [04-secure-api-gateway-identity](04-secure-api-gateway-identity/README.md)  
   Gateway seguro con OAuth2/OIDC, JWT, rate limiting y trazabilidad.

5. [05-finops-cloud-cost-guardian](05-finops-cloud-cost-guardian/README.md)  
   Servicio para analizar costos cloud y generar recomendaciones.

6. [06-rag-knowledge-assistant](06-rag-knowledge-assistant/README.md)  
   Asistente RAG para documentacion interna con embeddings y vector search.

7. [07-incident-response-runbook-system](07-incident-response-runbook-system/README.md)  
   Sistema de incidentes, postmortems, runbooks y SLOs.

8. [08-payment-risk-monitoring](08-payment-risk-monitoring/README.md)  
   Monitor de transacciones con reglas, auditoria y trazabilidad.

9. [09-batch-reporting-modernization](09-batch-reporting-modernization/README.md)  
   Modernizacion de batch/reporting enterprise con Spring Batch.

10. [10-platform-engineering-service-template](10-platform-engineering-service-template/README.md)  
    Template interno para crear microservicios productivos.

11. [11-modular-monolith-to-microservices](11-modular-monolith-to-microservices/README.md)  
    Evolucion de monolito modular a microservicios con criterio.

12. [12-ai-ticket-triage-service](12-ai-ticket-triage-service/README.md)  
    Servicio de clasificacion de tickets con IA aplicada y outputs estructurados.

## Como usar esta cartera

No hace falta construir todos al 100%. La estrategia recomendada es:

1. Construir completo el proyecto 1.
2. Incorporar piezas de los proyectos 2, 3 y 4 dentro del proyecto 1.
3. Construir PoCs defendibles de los proyectos 5, 6, 7 y 12.
4. Usar los proyectos 8, 9, 10 y 11 como historias tecnicas para entrevistas senior.

## Cobertura global

Entre todos los proyectos se cubre:

- Java 21,
- Spring Boot 3,
- Spring Security,
- Spring Batch,
- Spring AI,
- PostgreSQL,
- JPA/Hibernate,
- SQL con criterio,
- Flyway,
- Redis,
- Kafka/RabbitMQ/SQS,
- Docker,
- Docker Compose,
- Kubernetes conceptual/practico,
- AWS ECS/Fargate,
- AWS RDS,
- AWS SQS/SNS,
- AWS CloudWatch,
- AWS IAM,
- Secrets Manager,
- OpenAPI,
- JUnit 5,
- Mockito,
- Testcontainers,
- WireMock,
- CI/CD,
- Micrometer,
- Actuator,
- OpenTelemetry,
- logs estructurados,
- metricas,
- trazas,
- SLI/SLO,
- alertas,
- runbooks,
- idempotencia,
- outbox pattern,
- retries,
- DLQ,
- circuit breaker,
- rate limiting,
- OAuth2/OIDC,
- JWT,
- RAG,
- embeddings,
- vector database,
- evaluacion de respuestas,
- control de costos,
- ADRs,
- C4 diagrams,
- system design.
