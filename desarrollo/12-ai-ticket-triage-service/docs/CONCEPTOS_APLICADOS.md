# Conceptos aplicados

## IA aplicada a backend

El proyecto modela un puerto `TriageModelPort` y dos adapters:

- `RuleBasedTriageModelAdapter` para fallback local.
- `ExternalTriageModelAdapter` para llamar un proveedor HTTP compatible con el contrato de triage.

## Structured outputs

`TriageResult` define un contrato estructurado que debe validar la salida del modelo.

## Prompt versioning

`PROMPT_VERSION` permite auditar que version de prompt produjo una clasificacion.

## Fallback

La implementacion rule-based actua como fallback si el proveedor LLM falla o devuelve una salida invalida.

## Cost observability

`TriageProviderMetrics` registra llamadas al proveedor, fallbacks, tokens de entrada/salida y costo estimado.
El adapter externo lee los headers `X-Input-Tokens`, `X-Output-Tokens` y `X-Estimated-Cost-Usd` cuando el proveedor los entrega.

## Data guardrails

`SensitiveDataRedactor` reemplaza emails, numeros de tarjeta, documentos y telefonos antes de llamar al proveedor externo.
Esto reduce exposicion innecesaria de datos personales y permite testear el contrato de privacidad de forma deterministica.

## Conceptos del perfil que cubre

- LLM integration.
- Structured outputs.
- Prompt versioning.
- Provider abstraction.
- Fallback operativo.
- Metricas de costo/tokens.
- Seguridad de datos.
