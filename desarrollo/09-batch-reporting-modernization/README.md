# Batch Reporting Modernization

## Problema real que resuelve

Muchas empresas mantienen procesos batch antiguos para reportes, conciliaciones o integraciones. Este proyecto demuestra modernizacion pragmatica sin romper procesos criticos.

## Capacidades funcionales

- Ingesta de archivo CSV/JSON.
- Validacion de registros.
- Procesamiento por chunks.
- Job `transactionImportJob` con reader, processor y writer.
- Escritura en PostgreSQL.
- Reporte de errores.
- Reintentos.
- Reprocesamiento controlado.
- Metricas de batch.

## Stack aplicado

- Java 21.
- Spring Boot 3.
- Spring Batch.
- PostgreSQL.
- Flyway.
- Docker Compose.
- Testcontainers.
- Micrometer.
- Actuator.

## Patrones y soluciones

- Batch processing.
- Chunk-oriented processing.
- Restartability.
- Skip/retry policy.
- Idempotencia por archivo/lote.
- Auditoria de ejecucion.
- Separacion staging/final.
- Observabilidad batch.

## Diseno sugerido

Jobs:

- `customer-import-job`
- `transaction-reconciliation-job`
- `daily-report-job`

## Implementacion actual

El proyecto incluye el job `transactionImportJob`, registrado cuando existe infraestructura Spring Batch (`JobRepository`).

Componentes:

- `transactionItemReader`: reader con datos de ejemplo.
- `TransactionValidationItemProcessor`: valida registros y envia rechazados a `TransactionImportPort`.
- `TransactionImportItemWriter`: escribe transacciones validas por el puerto de importacion.

El endpoint `/api/batch/transactions/preview` sigue disponible para probar una transaccion individual sin lanzar el job completo.

Tablas:

- `batch_execution_audit`
- `staging_records`
- `validated_records`
- `rejected_records`

## Que se puede defender en entrevista

- Como modernizar legacy sin reescribir todo.
- Como hacer batches reiniciables.
- Como observar throughput, errores y duracion.
- Como disenar reprocesamiento seguro.
- Como manejar datos malos sin detener todo.

## Entregables

- Job Spring Batch.
- Datos de ejemplo.
- Reporte de errores.
- Tests de processor/writer.
- Dashboard de batch.
- ADR sobre estrategia de modernizacion.
