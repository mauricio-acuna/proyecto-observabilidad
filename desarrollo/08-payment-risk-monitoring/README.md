# Payment Risk Monitoring

## Problema real que resuelve

Un sistema financiero necesita monitorear transacciones para detectar patrones de riesgo, generar alertas y auditar decisiones sin bloquear innecesariamente el flujo de pago.

## Capacidades funcionales

- Recepcion de transacciones.
- Evaluacion de reglas de riesgo.
- Alertas por transacciones sospechosas.
- Auditoria de decisiones.
- Procesamiento asincrono.
- Consulta de historial.

## Stack aplicado

- Java 21.
- Spring Boot 3.
- PostgreSQL.
- Kafka/RabbitMQ/SQS.
- Redis opcional.
- OpenAPI.
- Testcontainers.
- Micrometer.
- OpenTelemetry.

## Patrones y soluciones

- Event-driven architecture.
- Rules engine simple.
- Idempotencia.
- Outbox pattern.
- Audit logging.
- CQRS ligero para consultas.
- Backpressure conceptual.
- Eventual consistency.
- Observabilidad de negocio.

## Diseno sugerido

Eventos:

- `PaymentReceived`
- `RiskEvaluated`
- `RiskAlertCreated`

Reglas:

- monto inusual,
- pais riesgoso,
- demasiados intentos,
- cliente nuevo con importe alto.

## Que se puede defender en entrevista

- Como separar decision sincronica y analisis asincrono.
- Como auditar reglas.
- Como observar falsos positivos.
- Como disenar para trazabilidad en sistemas financieros.
- Como evitar duplicar alertas.

## Entregables

- API de transacciones.
- Motor de reglas simple.
- Consumidor de eventos.
- Auditoria.
- Dashboard de alertas.
- Tests de reglas.

