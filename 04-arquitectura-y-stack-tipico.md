# Arquitectura y stack típico de observabilidad

## Idea general

Un stack de observabilidad no es una sola herramienta. Es una cadena de responsabilidades.

La versión mental más útil es esta:

1. la aplicación **genera** telemetría,
2. algún componente la **recibe y procesa**,
3. uno o varios backends la **almacenan e indexan**,
4. el equipo la **consulta, visualiza y usa** para operar.

## Capa 1: instrumentación en la aplicación

En un sistema Java moderno, aquí suele haber una mezcla de:

- Spring Boot Actuator,
- Micrometer,
- OpenTelemetry SDK o Java agent,
- logging estructurado.

### Qué sale de aquí

- métricas,
- trazas,
- logs,
- contexto de correlación.

### Qué error conviene evitar

Pensar que esta capa debe conocer demasiado del backend final. Cuanto más acoplada esté la app a un producto concreto, peor capacidad de evolución tendrás.

## Capa 2: transporte y protocolo

Hoy la conversación estándar gira mucho alrededor de **OTLP** como protocolo de exportación en el ecosistema OpenTelemetry.

Esto importa porque permite una tubería más homogénea entre aplicaciones, collectors y backends.

## Capa 3: collector o gateway de telemetría

En entornos pequeños puedes enviar datos directo al backend. En cuanto el entorno crece, suele aparecer un collector.

### Qué hace un collector

- recibir telemetría,
- procesarla,
- enriquecerla,
- filtrar,
- muestrear,
- transformar,
- exportarla a uno o varios destinos.

### Por qué es valioso

Porque desacopla a las aplicaciones del backend y te da un punto central para gobernar comportamiento.

## Capa 4: almacenamiento y consulta

No todos los datos tienen la misma naturaleza, así que no siempre van al mismo sitio.

### Backend de métricas

Suele optimizarse para series temporales y consultas agregadas.

### Backend de trazas

Se centra en recorridos, spans, dependencias y tiempos distribuidos.

### Backend de logs

Se orienta a búsqueda, indexación y análisis de eventos textuales o estructurados.

### Realidad práctica

A veces estas funciones viven en productos distintos. Otras veces, en una plataforma integrada. Ninguna de las dos opciones es automáticamente mejor: depende de complejidad, presupuesto, capacidades internas y requisitos operativos.

## Capa 5: visualización y operación

Aquí entran:

- dashboards,
- exploración de trazas,
- búsqueda de logs,
- alertas,
- reportes,
- SLOs,
- runbooks.

Esta capa es la visible, pero no sirve de mucho si lo anterior está mal diseñado.

## Ejemplo de stack abierto bastante típico

Una variante muy vista en entornos cloud-native es:

- **OpenTelemetry** para instrumentación,
- **OpenTelemetry Collector** para recepción/procesamiento,
- **Prometheus/Mimir** para métricas,
- **Tempo/Jaeger** para trazas,
- **Loki/Elastic** para logs,
- **Grafana** para visualización.

No es el único stack posible. Sí es una composición bastante reconocible en entornos modernos.

## Ejemplo de stack con vendor integrado

Otra opción muy común es usar una plataforma integrada que reciba la telemetría y resuelva:

- ingestión,
- almacenamiento,
- dashboards,
- alertas,
- correlación.

Ventajas posibles:

- menor esfuerzo inicial,
- experiencia más integrada,
- time-to-value más corto.

Costes o límites posibles:

- lock-in,
- control más limitado de ciertos detalles,
- costes crecientes al escalar volumen.

## Diseño por señales

## Métricas

Se usan bien para:

- alertado,
- tendencias,
- capacidad,
- KPIs técnicos y funcionales.

Requieren cuidar mucho:

- naming,
- etiquetas,
- cardinalidad,
- retención.

## Trazas

Se usan bien para:

- causalidad,
- breakdown de latencia,
- dependencias entre servicios,
- incidentes complejos.

Requieren cuidar:

- sampling,
- propagación de contexto,
- semántica de spans.

## Logs

Se usan bien para:

- evidencia puntual,
- excepciones,
- auditoría técnica,
- eventos significativos.

Requieren cuidar:

- estructura,
- volumen,
- indexación,
- sensibilidad de datos.

## Arquitectura mínima viable para un equipo pequeño

Si no quieres sobrecomplicar, una arquitectura inicial razonable podría ser:

- Spring Boot + Actuator,
- Micrometer,
- OpenTelemetry Java agent,
- collector único,
- backend sencillo de métricas y trazas,
- logs estructurados centralizados.

Con eso ya puedes tener:

- health checks,
- latencia,
- errores,
- trazas distribuidas básicas,
- correlación inicial.

## Arquitectura para entorno más maduro

Cuando el número de servicios, equipos o entornos crece, normalmente aparecen necesidades nuevas:

- collectors por capa o por entorno,
- pipelines distintos por tipo de señal,
- sampling adaptativo,
- múltiples destinos,
- redacción de datos sensibles,
- controles de coste,
- ownership por dominio,
- SLOs por servicio.

## Dónde se rompen muchos stacks

No se rompen solo por tecnología. Se rompen por decisiones pobres.

### 1. Se genera demasiada telemetría irrelevante

Resultado:

- coste alto,
- baja señal/ruido,
- diagnósticos lentos.

### 2. No hay estándares internos

Resultado:

- nombres inconsistentes,
- dashboards incomparables,
- spans imposibles de leer.

### 3. No se piensa en el uso operativo

Resultado:

- dashboards bonitos pero inútiles,
- alertas que nadie puede accionar,
- trazas que existen pero nadie consulta.

### 4. Se diseña solo para incidentes técnicos

Resultado:

- visibilidad de CPU y memoria,
- pero poca idea del impacto en flujos de negocio.

## Preguntas de diseño que sí valen la pena

Antes de discutir herramientas, conviene responder:

- ¿qué incidentes queremos resolver más rápido?
- ¿qué servicios son críticos?
- ¿qué señales faltan hoy?
- ¿qué coste estamos dispuestos a pagar?
- ¿qué datos necesitan larga retención y cuáles no?
- ¿qué atributos deben ser obligatorios?
- ¿dónde pondremos sampling y por qué?
- ¿cómo conectamos observabilidad con ownership y on-call?

## Resumen operativo del stack

Un stack típico y sano suele cumplir esto:

- la app emite telemetría estándar,
- el collector desacopla y gobierna,
- los backends almacenan según la naturaleza de la señal,
- la visualización permite diagnosticar,
- las alertas están conectadas con impacto,
- y el equipo comparte convenciones.

## Cierre

La mejor arquitectura no es la más grande. Es la que logra el equilibrio correcto entre:

- utilidad diagnóstica,
- simplicidad operativa,
- coste,
- y capacidad de evolución.

En observabilidad, sofisticación sin gobernanza suele terminar peor que una arquitectura más modesta pero bien diseñada.
