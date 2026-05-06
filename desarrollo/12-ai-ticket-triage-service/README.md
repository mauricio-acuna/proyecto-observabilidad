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
- Adapter HTTP externo configurable para proveedor LLM.
- Redaccion de datos sensibles antes de llamar al proveedor externo.
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
- `llm-provider-client` via `ExternalTriageModelAdapter`
- `prompt-registry`
- `classification-validator`
- `cost-tracker`
- `audit-log`

## Configuracion local actual

Por defecto usa clasificacion rule-based:

```bash
APP_AI_PROVIDER=rule-based
```

Para activar un proveedor externo compatible con el contrato JSON:

```bash
APP_AI_PROVIDER=external
APP_AI_EXTERNAL_BASE_URL=http://localhost:8099
APP_AI_EXTERNAL_API_KEY=dev-token
```

El adapter externo llama `POST /v1/triage`, valida campos obligatorios de `TriageResult` y vuelve al fallback rule-based si el proveedor falla o devuelve una salida invalida.
Antes de enviar el payload, `SensitiveDataRedactor` reemplaza emails, tarjetas, documentos y telefonos por placeholders.

Si el proveedor devuelve headers de consumo, el servicio registra metricas Micrometer:

- `ai_triage_provider_requests_total`
- `ai_triage_fallback_total`
- `ai_triage_tokens_total`
- `ai_triage_estimated_cost_usd_total`

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
- Tests de adapter externo con HTTP mockeado.
- Fallback rule-based.
- Guardrails de redaccion de datos sensibles.
- Metricas de provider, fallback, tokens y costo estimado.
- ADR sobre uso seguro de IA.
