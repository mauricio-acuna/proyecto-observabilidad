# Conceptos aplicados

## FinOps

El proyecto convierte costos cloud en recomendaciones tecnicas accionables.

## Integracion externa

`CostProviderPort` permite reemplazar el proveedor simulado por un provider HTTP estilo AWS Cost Explorer.
`AwsCostExplorerHttpProvider` queda activable por configuracion y vuelve al provider simulado si la API externa falla.

## Trade-off tecnico-economico

Las recomendaciones estiman ahorro, conectando arquitectura con negocio.

## Observabilidad financiera

`CostAnalysisObserver` permite observar el resultado del analisis sin acoplar el caso de uso a Micrometer.
`FinOpsMetrics` publica gasto analizado, recomendaciones por severidad y ahorro mensual estimado.

## Conceptos del perfil que cubre

- AWS Cost Explorer/Budgets.
- Costos.
- Integraciones externas.
- Fallback ante fallos de proveedor.
- Metricas financieras.
- Scheduled analysis.
- Observabilidad financiera.
- Comunicacion senior con negocio.
