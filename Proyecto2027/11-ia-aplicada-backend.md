# IA aplicada a backend

## Decision

La IA entra al proyecto 2027 como complemento backend. No cambia la identidad profesional principal.

Identidad principal:

**Senior Java Backend / Cloud Engineer**

Complemento:

**capaz de integrar capacidades de IA en sistemas backend confiables.**

## Que si aprender

- LLM APIs.
- Structured outputs.
- Function/tool calling.
- Prompt versioning.
- Rate limits.
- Retry/backoff.
- Cost control.
- Streaming.
- Logging seguro.
- Prompt injection.
- Data privacy.
- Embeddings.
- RAG.
- Vector databases.
- Evaluacion basica.
- Observabilidad de IA.

## Que no perseguir

- ML engineering completo.
- Entrenamiento de modelos.
- Diplomaturas generalistas como eje.
- Venderse como AI Engineer sin experiencia real.
- Agentes autonomos complejos antes de dominar RAG simple.

## Proyecto recomendado

### Nombre

**rag-knowledge-assistant**

### Caso de uso

Asistente para consultar documentacion interna de soporte, banca o procedimientos operativos.

### Funcionalidad minima

- Cargar documentos.
- Extraer texto.
- Dividir en chunks.
- Generar embeddings.
- Guardar en PostgreSQL + pgvector o Qdrant.
- Buscar por similitud.
- Construir contexto.
- Generar respuesta con citas.
- Rechazar preguntas sin evidencia.
- Medir latencia y costo.

### Stack

- Java 21.
- Spring Boot 3.
- Spring AI.
- PostgreSQL + pgvector o Qdrant.
- OpenAI, Azure OpenAI o Bedrock.
- Docker Compose.
- REST API.
- Tests.
- OpenTelemetry/Micrometer.

## Observabilidad especifica de IA

Medir:

- latencia total,
- latencia de retrieval,
- latencia del modelo,
- tokens input/output,
- costo estimado,
- errores del proveedor,
- fallback usado,
- cantidad de chunks recuperados,
- score de similitud,
- respuestas sin evidencia.

## Seguridad

Debe incluir:

- no enviar secretos al modelo,
- masking de PII si aplica,
- validacion de inputs,
- limite de longitud,
- proteccion basica ante prompt injection,
- logs sin datos sensibles,
- separacion entre prompt interno y contenido de usuario.

## Frase segura para entrevistas

> I do not position myself as an ML engineer. My value is integrating AI capabilities into reliable backend systems, with attention to security, observability, cost control and production trade-offs.

## Cuando hacerlo

Despues de tener avanzado:

- CV,
- proyecto Java principal,
- AWS base,
- preparacion de entrevistas.

Si el proyecto IA compite con esos puntos, se posterga.

