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

## ADR-003: Agregar proveedor HTTP externo con fallback

### Decision

Activar un adapter HTTP externo cuando `APP_AI_PROVIDER=external`.
El adapter llama `POST /v1/triage`, redacta datos sensibles antes de enviar el payload, exige salida compatible con `TriageResult` y usa `RuleBasedTriageModelAdapter` como fallback ante error o respuesta invalida.

### Motivo

Permite demostrar integracion LLM realista sin acoplar el caso de uso a OpenAI, Azure OpenAI o Bedrock.
El fallback mantiene disponibilidad y hace que el servicio sea defendible aunque el proveedor externo falle.

### Consecuencias

- El contrato externo queda reducido a JSON estructurado.
- La API puede correr sin credenciales usando `rule-based`.
- Se registran metricas de llamadas al provider, fallback, tokens y costo estimado cuando el provider entrega headers de consumo.
- Se evitan fugas obvias de emails, tarjetas, documentos y telefonos hacia el proveedor externo.
- Falta agregar pruebas de contrato con WireMock.
