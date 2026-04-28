# Batch Reporting Modernization

## Problema real que resuelve

Muchas empresas mantienen procesos batch antiguos para reportes, conciliaciones o integraciones. Este proyecto demuestra modernizacion pragmatica sin romper procesos criticos.

## Capacidades funcionales

- Ingesta de archivo CSV/JSON.
- Validacion de registros.
- Procesamiento por chunks.
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
- Tests de job.
- Dashboard de batch.
- ADR sobre estrategia de modernizacion.

