# Prompts operativos para IA

## Como usar

Copiar el prompt correspondiente cuando se quiera que una IA continue el trabajo.

La IA debe leer primero:

- `Proyecto2027/13-instrucciones-ia-director-area.md`
- `Proyecto2027/14-plan-entrega-calidad.md`
- `desarrollo/00-estado-implementacion.md`
- `desarrollo/00-validacion-calidad.md`
- `desarrollo/00-deuda-tecnica-y-sprints.md`

## Prompt maestro

```text
Actua como Director de Area de Ingenieria para Proyecto2027.

Objetivo: llevar la carpeta desarrollo a un estado de alta calidad entregable antes del 31 de enero de 2027.

No priorices velocidad. Prioriza calidad, trazabilidad, pruebas, documentacion, arquitectura y evidencia defendible en entrevistas senior.

Antes de tocar codigo:
1. Lee Proyecto2027/13-instrucciones-ia-director-area.md.
2. Lee Proyecto2027/14-plan-entrega-calidad.md.
3. Lee desarrollo/00-estado-implementacion.md.
4. Lee desarrollo/00-validacion-calidad.md.
5. Lee desarrollo/00-deuda-tecnica-y-sprints.md.

Reglas:
- Mantener gradle clean test en verde.
- No ocultar deuda tecnica.
- Actualizar ADRs y documentacion.
- Agregar tests para cada cambio.
- Ejecutar validacion al final.
- Reportar que cambio, como se probo, que deuda queda y siguiente paso.

Empieza por el siguiente sprint pendiente segun Proyecto2027/14-plan-entrega-calidad.md.
```

## Prompt Sprint 1 - Estabilizacion

```text
Ejecuta Sprint 1 de Proyecto2027.

Objetivo: estabilizar build y calidad base.

Tareas:
- Verificar JDK disponible.
- Si hay JDK 21, migrar Gradle a Java 21.
- Agregar JaCoCo.
- Agregar Spotless o Checkstyle.
- Mantener gradle clean test en verde.
- Actualizar desarrollo/00-validacion-calidad.md.
- Actualizar desarrollo/00-deuda-tecnica-y-sprints.md.

No cierres el sprint si el build falla.
```

## Prompt Sprint 2 - Persistencia

```text
Ejecuta Sprint 2 de Proyecto2027 sobre desarrollo/01-plataforma-soporte-bancario.

Objetivo: reemplazar adapters in-memory por PostgreSQL/Flyway/Testcontainers.

Tareas:
- Agregar dependencias Spring Data JPA, PostgreSQL, Flyway y Testcontainers.
- Crear entidades JPA separadas del dominio si conviene.
- Crear migraciones Flyway.
- Implementar repositorios reales.
- Mantener tests unitarios.
- Agregar tests de integracion.
- Agregar docker-compose con PostgreSQL.
- Actualizar README, CONCEPTOS_APLICADOS y ADRS.
- Ejecutar gradle clean test.
```

## Prompt Sprint 3 - Eventos reales

```text
Ejecuta Sprint 3 de Proyecto2027.

Objetivo: implementar flujo de eventos real entre plataforma soporte bancario y notification hub.

Tareas:
- Elegir broker pragmatico para entorno local.
- Documentar decision en ADR.
- Implementar outbox persistente.
- Implementar consumidor idempotente.
- Implementar retries y DLQ.
- Agregar tests de duplicados y fallo.
- Exponer metricas de procesamiento.
- Actualizar dashboard y documentacion.
- Ejecutar gradle clean test.
```

## Prompt Sprint 4 - Observabilidad

```text
Ejecuta Sprint 4 de Proyecto2027.

Objetivo: observabilidad end-to-end.

Tareas:
- Agregar OpenTelemetry Collector.
- Propagar traceId/correlationId.
- Configurar logs estructurados.
- Agregar dashboards.
- Definir SLI/SLO.
- Crear runbook de incidente.
- Probar request end-to-end.
- Documentar cardinalidad, sampling y costos.
- Ejecutar gradle clean test.
```

## Prompt Sprint 5 - Seguridad

```text
Ejecuta Sprint 5 de Proyecto2027.

Objetivo: gateway seguro.

Tareas:
- Configurar Keycloak o mock OIDC.
- Validar JWT.
- Agregar roles.
- Agregar rate limiting.
- Tests para 401, 403 y 429.
- Propagar correlation id.
- Documentar ADR de seguridad.
- Ejecutar gradle clean test.
```

## Prompt Sprint 6 - Performance

```text
Ejecuta Sprint 6 de Proyecto2027.

Objetivo: baseline de performance y resiliencia.

Tareas:
- Levantar servicios necesarios.
- Ejecutar k6 sobre endpoints criticos.
- Registrar p95, error rate y throughput.
- Agregar Resilience4j donde aplique.
- Probar timeouts/circuit breakers.
- Documentar resultados.
- Actualizar dashboard.
- Ejecutar gradle clean test.
```

## Prompt Sprint 7 - IA aplicada

```text
Ejecuta Sprint 7 de Proyecto2027.

Objetivo: IA aplicada real y testeable.

Tareas:
- Implementar adapter LLM real o WireMock contractual.
- Agregar prompt versioning.
- Validar structured outputs.
- Implementar RAG con pgvector o Qdrant.
- Medir tokens, costo y latencia.
- Agregar guardrails basicos.
- Crear tests de respuestas sin evidencia.
- Documentar limites y riesgos.
- Ejecutar gradle clean test.
```

## Prompt Sprint 8 - Cierre portfolio

```text
Ejecuta Sprint 8 de Proyecto2027.

Objetivo: preparar portfolio final para entrevistas.

Tareas:
- Revisar todos los README.
- Crear diagramas.
- Crear scripts de demo.
- Actualizar dashboard.
- Crear historias STAR por proyecto.
- Crear guia de entrevista tecnica.
- Confirmar build y tests.
- Documentar deuda final.
- Ejecutar gradle clean test.
```

