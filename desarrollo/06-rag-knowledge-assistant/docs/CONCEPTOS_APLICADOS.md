# Conceptos aplicados

## RAG

`AskKnowledgeBaseUseCase` primero recupera contexto y luego genera respuesta.

## Vector search

`VectorSearchPort` representa pgvector, Qdrant, Pinecone o Azure AI Search.

## LLM abstraction

`LanguageModelPort` permite cambiar OpenAI, Azure OpenAI o Bedrock.

## Respuestas con evidencia

Si no hay chunks, el sistema rechaza responder. Este punto permite hablar de reduccion de alucinaciones.

## Conceptos del perfil que cubre

- IA aplicada a backend.
- RAG.
- Embeddings/vector search.
- Separacion de proveedores.
- Guardrails basicos.
- Observabilidad de IA como siguiente paso.

