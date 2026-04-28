# Conceptos aplicados

## Spring Batch

El `pom.xml` incluye Spring Batch. El codigo inicial separa validacion y salida para luego conectarlo a readers/processors/writers.

## Restartability

El siguiente paso es persistir estado de ejecucion para reiniciar lotes fallidos.

## Staging y rechazo

`TransactionImportPort` separa registros validos y rechazados, patron habitual en integraciones batch.

## Conceptos del perfil que cubre

- Modernizacion legacy.
- Procesos batch.
- Validacion de datos.
- Auditoria.
- Observabilidad batch.
- Reprocesamiento seguro.

