# Glosario rápido

## Observabilidad
Capacidad de entender el estado interno de un sistema a partir de sus salidas externas.

## Monitorización
Seguimiento de métricas, eventos o estados conocidos, normalmente con umbrales o alertas predefinidas.

## Telemetría
Conjunto de datos emitidos por un sistema para describir su comportamiento. Suele incluir logs, métricas y trazas.

## Log
Registro de un evento discreto ocurrido en un instante concreto.

## Log estructurado
Log emitido en un formato consistente y parseable, típicamente JSON, con campos consultables.

## Métrica
Medida numérica agregable a lo largo del tiempo.

## Time series
Serie temporal de valores de una métrica observados a lo largo del tiempo.

## Traza
Representación del recorrido de una petición o transacción a través de uno o más componentes.

## Span
Unidad básica dentro de una traza. Representa una operación con duración, contexto y atributos.

## Trace ID
Identificador común que agrupa los spans pertenecientes a una misma traza.

## Span ID
Identificador de un span individual dentro de una traza.

## Correlación
Capacidad de relacionar logs, métricas y trazas para analizar un mismo problema desde varios ángulos.

## Propagación de contexto
Mecanismo por el cual identificadores y metadatos de observabilidad viajan entre servicios o procesos.

## Instrumentación
Adición de código, librerías o agentes para generar telemetría.

## Auto-instrumentación
Instrumentación automática, normalmente mediante agentes o integraciones prehechas, con pocos cambios en el código.

## Instrumentación manual
Instrumentación hecha explícitamente por el equipo dentro del código de la aplicación.

## OpenTelemetry
Estándar y conjunto de herramientas para generar, recolectar, procesar y exportar telemetría.

## OTLP
OpenTelemetry Protocol. Protocolo común de exportación en el ecosistema OpenTelemetry.

## OpenTelemetry Collector
Componente que recibe, procesa y exporta telemetría hacia uno o varios destinos.

## Micrometer
Librería de observación e instrumentación muy usada en el ecosistema Spring.

## Spring Boot Actuator
Módulo de Spring Boot que expone capacidades operativas y de observabilidad como health, métricas y otros endpoints.

## Cardinalidad
Cantidad de valores distintos que puede tomar una etiqueta o atributo.

## Sampling
Técnica para conservar solo una parte de las trazas o eventos, reduciendo volumen y coste.

## Dashboard
Vista agregada de métricas y otros datos para seguimiento y diagnóstico.

## Alerta
Notificación disparada cuando una condición relevante se cumple.

## Latencia
Tiempo que tarda una operación en completarse.

## Throughput
Cantidad de operaciones o requests procesadas por unidad de tiempo.

## Error rate
Proporción de operaciones que terminan en error.

## SLI
Service Level Indicator. Medida concreta del comportamiento del servicio.

## SLO
Service Level Objective. Objetivo definido sobre uno o varios SLI.

## SLA
Service Level Agreement. Compromiso formal de nivel de servicio, normalmente contractual.

## MTTR
Mean Time To Recovery o Restore. Tiempo medio de recuperación ante incidentes.

## Backend de observabilidad
Sistema que almacena, indexa y permite consultar telemetría.

## Etiqueta / label / tag
Dimensión asociada a una métrica o evento para clasificar y filtrar datos.

## Señal de negocio
Telemetría que describe comportamiento funcional relevante para el negocio.

## Señal técnica
Telemetría que describe comportamiento técnico del sistema o la infraestructura.
