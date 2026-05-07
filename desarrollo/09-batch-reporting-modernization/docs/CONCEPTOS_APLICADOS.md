# Conceptos aplicados

## Spring Batch

El proyecto define `transactionImportJob` con `ListItemReader`, `TransactionValidationItemProcessor` y `TransactionImportItemWriter`.
La configuracion queda condicionada a `JobRepository` para poder activarla cuando exista infraestructura batch.

## Restartability

El siguiente paso es persistir metadata de ejecucion para reiniciar lotes fallidos.

## Staging y rechazo

`TransactionImportPort` separa registros validos y rechazados, patron habitual en integraciones batch.
El processor envia rechazados con motivo y el writer envia validos al mismo puerto.

## Metricas batch

`BatchImportMetrics` publica `batch_transactions_total` con resultado `valid` o `rejected`.
Esto permite medir calidad del archivo y volumen procesado sin leer logs.

## Conceptos del perfil que cubre

- Modernizacion legacy.
- Procesos batch.
- Validacion de datos.
- Auditoria.
- Observabilidad batch.
- Reprocesamiento seguro.
