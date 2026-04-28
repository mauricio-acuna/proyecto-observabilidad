# RAG Knowledge Assistant

## Problema real que resuelve

Equipos de soporte, banca o operaciones tienen documentacion dispersa. Las personas pierden tiempo buscando procedimientos y pueden responder con informacion incompleta.

Este proyecto demuestra IA aplicada a backend sin venderse como ML Engineer.

## Capacidades funcionales

- Carga de documentos.
- Extraccion de texto.
- Chunking.
- Generacion de embeddings.
- Almacenamiento vectorial.
- Busqueda semantica.
- Construccion de contexto.
- Respuesta con citas.
- Rechazo cuando no hay evidencia.
- Medicion de calidad basica.

## Stack aplicado

- Java 21.
- Spring Boot 3.
- Spring AI.
- OpenAI, Azure OpenAI o Amazon Bedrock.
- PostgreSQL + pgvector o Qdrant.
- Docker Compose.
- OpenAPI.
- Testcontainers.
- Micrometer.
- OpenTelemetry.

## Patrones y soluciones

- RAG.
- Embeddings.
- Vector search.
- Metadata filtering.
- Context assembly.
- Prompt templates.
- Structured response.
- Guardrails basicos.
- Evaluacion con dataset.
- Observabilidad de IA.

## Diseno sugerido

Servicios/modulos:

- `document-ingestion`
- `embedding-service`
- `retrieval-service`
- `answer-generation`
- `evaluation`

Metricas:

- latencia total,
- latencia retrieval,
- tokens input/output,
- costo estimado,
- chunks recuperados,
- respuestas sin evidencia.

## Que se puede defender en entrevista

- Que problema resuelve RAG.
- Por que no basta con llamar a una API de LLM.
- Como reducir alucinaciones.
- Como medir calidad.
- Como controlar costo y latencia.
- Como proteger datos sensibles.

## Entregables

- API de carga documental.
- API de preguntas.
- Vector DB local.
- Dataset de evaluacion.
- Dashboard de costo/latencia.
- README con limites del enfoque.

