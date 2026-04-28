# AI Ticket Triage Service

## Problema real que resuelve

Los equipos de soporte reciben tickets con distinta urgencia, categoria y complejidad. Clasificarlos manualmente consume tiempo y genera inconsistencias.

Este proyecto aplica IA de forma acotada y defendible dentro de un backend.

## Capacidades funcionales

- Clasificar ticket por categoria.
- Detectar prioridad.
- Extraer entidades.
- Generar resumen.
- Sugerir siguiente accion.
- Devolver salida JSON estructurada.
- Registrar costo, latencia y errores.
- Fallback si falla el proveedor.

## Stack aplicado

- Java 21.
- Spring Boot 3.
- Spring AI o cliente LLM directo.
- OpenAI/Azure OpenAI/Bedrock.
- PostgreSQL.
- WireMock.
- Testcontainers.
- Micrometer.
- OpenTelemetry.

## Patrones y soluciones

- Structured outputs.
- Prompt templates.
- Prompt versioning.
- Provider abstraction.
- Fallback.
- Retry/backoff.
- Rate limiting.
- Cost guard.
- Output validation.
- Safe logging.

## Diseno sugerido

Componentes:

- `triage-api`
- `llm-provider-client`
- `prompt-registry`
- `classification-validator`
- `cost-tracker`
- `audit-log`

## Que se puede defender en entrevista

- Por que no basta con "hacer un POST al modelo".
- Como validar outputs.
- Como limitar costo por request.
- Como manejar errores del proveedor.
- Como evitar exponer datos sensibles.
- Como medir si el clasificador mejora el flujo.

## Entregables

- API de triage.
- Prompts versionados.
- JSON schema de salida.
- Tests con WireMock.
- Metricas de tokens/costo/latencia.
- ADR sobre uso seguro de IA.

