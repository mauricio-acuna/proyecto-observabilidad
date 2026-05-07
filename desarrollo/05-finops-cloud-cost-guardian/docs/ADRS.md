# ADRs iniciales

## ADR-001: Modelar costos como dominio propio

### Decision

Crear `CloudCostRecord` y `CostRecommendation` en dominio.

### Motivo

Permite hablar de costos como parte de arquitectura, no como reporte externo.

## ADR-002: Integrar costos externos detras de un puerto

### Decision

Mantener `CostProviderPort` como contrato de aplicacion y agregar `AwsCostExplorerHttpProvider` activable con `APP_FINOPS_PROVIDER=aws-http`.
El provider simulado queda como default y como fallback ante errores o respuestas vacias.

### Motivo

Permite demostrar integracion con datos tipo AWS Cost Explorer sin acoplar el caso de uso a SDKs, credenciales ni disponibilidad externa.

### Consecuencias

- La logica de recomendaciones no cambia al reemplazar el origen de datos.
- Las pruebas pueden validar contrato HTTP con `MockRestServiceServer`.
- Falta agregar metricas financieras, alertas de presupuesto y un adapter AWS SDK real si se requieren credenciales reales.
