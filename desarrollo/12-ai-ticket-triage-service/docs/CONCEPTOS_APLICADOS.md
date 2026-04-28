# Conceptos aplicados

## IA aplicada a backend

El proyecto modela un puerto `TriageModelPort` para reemplazar una implementacion rule-based por OpenAI, Azure OpenAI o Bedrock.

## Structured outputs

`TriageResult` define un contrato estructurado que debe validar la salida del modelo.

## Prompt versioning

`PROMPT_VERSION` permite auditar que version de prompt produjo una clasificacion.

## Fallback

La implementacion rule-based puede actuar como fallback si el proveedor LLM falla.

## Conceptos del perfil que cubre

- LLM integration.
- Structured outputs.
- Prompt versioning.
- Provider abstraction.
- Cost/fallback como siguiente paso.
- Seguridad de datos.

