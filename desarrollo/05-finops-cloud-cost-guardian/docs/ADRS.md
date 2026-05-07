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
- Falta agregar alertas de presupuesto y un adapter AWS SDK real si se requieren credenciales reales.

## ADR-003: Observar el analisis FinOps como metrica de negocio

### Decision

Agregar `CostAnalysisObserver` como puerto de observacion del caso de uso y `FinOpsMetrics` como implementacion Micrometer.

### Motivo

Las recomendaciones FinOps no son solo datos tecnicos: deben poder medirse como gasto analizado, oportunidades detectadas y ahorro estimado.

### Consecuencias

- El caso de uso sigue sin depender de Micrometer.
- Prometheus puede consultar gasto analizado, recomendaciones y ahorro estimado.
- Falta agregar reglas de alerta para presupuestos y anomalias.

## ADR-004: Evaluar budget alerts en la capa de aplicacion

### Decision

Agregar `EvaluateBudgetAlertsUseCase` para agrupar gasto por servicio y ambiente, compararlo contra un presupuesto mensual configurable y devolver alertas con severidad.

### Motivo

Las alertas de presupuesto deben ser una regla de negocio visible y testeable, no solo una consulta de dashboard.

### Consecuencias

- El endpoint `/api/costs/budget-alerts` queda disponible para reportes o automatizacion.
- El umbral default se configura con `APP_FINOPS_DEFAULT_MONTHLY_BUDGET_USD`.
- Falta agregar deteccion de anomalias y notificaciones.
