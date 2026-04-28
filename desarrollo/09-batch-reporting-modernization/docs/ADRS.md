# ADRs iniciales

## ADR-001: Separar validacion de escritura final

### Decision

Crear `ValidateTransactionUseCase` y `TransactionImportPort`.

### Motivo

Permite cambiar almacenamiento, reportes de errores o reprocesamiento sin tocar reglas.

