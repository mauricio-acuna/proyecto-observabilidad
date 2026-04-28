# ADRs iniciales

## ADR-001: Centralizar seguridad de entrada en gateway

### Decision

Validar tokens JWT en el gateway para proteger rutas externas.

### Motivo

Reduce duplicacion de controles transversales y permite auditar accesos en un punto claro.

## ADR-002: Propagar correlation id

### Decision

El gateway garantiza que toda request tenga `X-Correlation-Id`.

### Motivo

Sin contexto compartido, la trazabilidad entre servicios se rompe.

