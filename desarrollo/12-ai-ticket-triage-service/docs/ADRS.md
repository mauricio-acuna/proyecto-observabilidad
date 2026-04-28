# ADRs iniciales

## ADR-001: Abstraer proveedor de IA

### Decision

Usar `TriageModelPort` en vez de invocar directamente un proveedor.

### Motivo

Permite cambiar modelo, agregar fallback, simular tests con WireMock y controlar costos.

## ADR-002: Usar salida estructurada

### Decision

Modelar `TriageResult` como contrato fijo.

### Motivo

Evita respuestas libres dificiles de integrar en backend.

