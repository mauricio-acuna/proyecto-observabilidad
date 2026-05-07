# ADRs iniciales

## ADR-001: Separar validacion de escritura final

### Decision

Crear `ValidateTransactionUseCase` y `TransactionImportPort`.

### Motivo

Permite cambiar almacenamiento, reportes de errores o reprocesamiento sin tocar reglas.

## ADR-002: Introducir job Spring Batch por componentes

### Decision

Agregar `transactionImportJob` con reader, processor y writer separados.
La configuracion del job queda condicionada a la presencia de `JobRepository`, mientras los componentes permanecen testeables sin base de datos.

### Motivo

Permite demostrar chunk-oriented processing sin bloquear el proyecto por infraestructura local de Spring Batch.

### Consecuencias

- El processor filtra registros invalidos y registra rechazados.
- El writer persiste validos mediante `TransactionImportPort`.
- Falta persistir metadata de ejecucion y habilitar reprocesamiento real con base de datos.
