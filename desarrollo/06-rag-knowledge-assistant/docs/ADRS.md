# ADRs iniciales

## ADR-001: Separar retrieval y generacion

### Decision

Modelar `VectorSearchPort` y `LanguageModelPort` por separado.

### Motivo

Permite medir, probar y cambiar cada fase del pipeline RAG.

