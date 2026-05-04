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

## Conceptos del perfil que cubre

- LLM integration.
- Structured outputs.
- Prompt versioning.
- Provider abstraction.
- Fallback operativo.
- Seguridad de datos.
