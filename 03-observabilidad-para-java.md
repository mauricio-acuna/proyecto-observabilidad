# Observabilidad para Java

## Por qué Java tiene una entrada relativamente buena a observabilidad

El ecosistema Java, y especialmente el de Spring Boot, tiene una ventaja práctica: hoy existe un camino bastante claro y razonablemente estándar para introducir observabilidad sin tener que inventar todo desde cero.

Ese camino suele pasar por:

- **Spring Boot Actuator**,
- **Micrometer**,
- **OpenTelemetry**,
- y en muchos casos un **OpenTelemetry Collector**.

Esto no significa que todas las organizaciones lo usen exactamente igual. Significa que hay una convergencia bastante fuerte en torno a estas piezas.

## Spring Boot como punto de partida

En aplicaciones Spring Boot, el primer paso realista suele ser incorporar:

- `spring-boot-starter-actuator`

Actuator expone endpoints y capacidades operativas útiles, y además encaja con el modelo de observabilidad de Spring.

No es “la solución completa”, pero sí un punto de entrada natural.

## Micrometer: la capa práctica del ecosistema Spring

Micrometer es, en términos prácticos, la librería base que durante años se volvió el estándar de facto en el ecosistema Spring para instrumentación de métricas y, más recientemente, de observaciones que pueden producir métricas y trazas.

### Qué aporta

- abstracción sobre distintos backends,
- timers, counters, gauges, summaries,
- observaciones coherentes con Spring,
- convenciones y soporte amplio.

### Qué no conviene malinterpretar

Micrometer no reemplaza por sí mismo toda la historia de observabilidad distribuida. Es una pieza muy importante dentro del ecosistema Spring, no el único estándar del espacio completo.

## OpenTelemetry: el estándar transversal

Si Micrometer es la puerta habitual desde Spring, **OpenTelemetry** es hoy el estándar abierto más importante para generar, procesar y exportar telemetría.

### Por qué importa

Porque evita quedar atado demasiado pronto a un vendor y da una semántica común para:

- trazas,
- métricas,
- logs,
- contexto,
- propagación,
- exportación.

### En Java, qué suele verse

Dos estrategias principales:

#### 1. Auto-instrumentación con Java agent

Es la forma más rápida de empezar.

Ventajas:

- bajo esfuerzo inicial,
- buena cobertura de frameworks y librerías comunes,
- ideal para obtener valor temprano.

Limitaciones:

- menor control fino,
- peor semántica de negocio,
- posible exceso de datos si no se gobierna bien.

#### 2. Instrumentación manual o semimanual

Se usa cuando el equipo necesita:

- spans de negocio,
- atributos propios,
- métricas específicas,
- mejor correlación en flujos concretos.

La madurez real suele aparecer cuando combinas ambas.

## La secuencia más habitual en un servicio Spring Boot moderno

Una ruta muy típica sería:

1. añadir Actuator,
2. activar métricas básicas,
3. exponer endpoints operativos necesarios,
4. introducir trazas con OpenTelemetry,
5. exportar por OTLP a un collector o backend,
6. añadir instrumentación funcional donde realmente aporte,
7. correlacionar logs con trace/span ids.

## Métricas que suelen importar en Java

Además de métricas de infraestructura, en Java suelen ser muy útiles estas categorías:

### Métricas HTTP

- throughput,
- errores por status,
- latencia por endpoint,
- percentiles.

### Métricas de JVM

- heap y non-heap,
- garbage collection,
- threads,
- uso de CPU,
- clases cargadas,
- pausas.

### Métricas de pools y clientes

- conexiones a base de datos,
- uso de pool,
- latencia de cliente HTTP,
- timeouts,
- reintentos.

### Métricas de negocio

- pedidos procesados,
- fallos de pago,
- mensajes consumidos,
- tiempos de pasos funcionales clave.

## Trazas en aplicaciones Java

Las trazas son especialmente valiosas cuando tu sistema tiene:

- varios microservicios,
- llamadas HTTP encadenadas,
- mensajería asíncrona,
- dependencia de base de datos y terceros,
- latencia difícil de explicar.

### Qué deberías capturar al menos

- nombre de operación coherente,
- duración,
- resultado,
- atributos de contexto relevantes,
- errores bien anotados,
- propagación correcta entre servicios.

### Qué no conviene hacer

- crear spans para cualquier cosa irrelevante,
- meter datos sensibles,
- convertir identificadores únicos de usuario en dimensiones de métricas,
- usar nombres inconsistentes entre servicios.

## Logs en Java: donde más se desperdicia valor

Muchos proyectos Java tienen logs, pero no necesariamente observabilidad útil.

Problemas frecuentes:

- logs sin estructura,
- exceso de `INFO` irrelevante,
- excepciones duplicadas varias veces,
- falta de correlación,
- mensajes difíciles de consultar.

### Qué conviene hacer

- logging estructurado,
- incluir trace id y span id cuando sea posible,
- usar niveles con disciplina,
- separar logs de debugging de eventos operativos reales,
- evitar secretos y datos sensibles.

## OpenTelemetry Collector: por qué suele aparecer pronto

Enviar telemetría directamente desde cada aplicación a cada backend no escala bien.

El collector suele introducirse para:

- centralizar recepción,
- transformar o filtrar datos,
- enrutar a varios destinos,
- aplicar procesamiento,
- desacoplar apps del backend final.

Es una pieza especialmente útil cuando el número de servicios crece.

## En qué orden empezar si partes de cero

### Fase 1: visibilidad mínima saludable

- Actuator,
- métricas base,
- endpoints de health,
- dashboards sencillos,
- logs estructurados.

### Fase 2: trazabilidad distribuida

- OpenTelemetry Java agent,
- exportación OTLP,
- backend de trazas,
- correlación básica con logs.

### Fase 3: semántica útil

- spans de negocio,
- métricas funcionales,
- alertas alineadas con impacto,
- políticas de cardinalidad y sampling.

## Qué esperar de cada enfoque

### Solo Actuator + métricas

Te sirve para:

- detectar degradaciones,
- ver salud general,
- activar alertas básicas.

No te servirá tan bien para:

- entender causalidad distribuida,
- aislar cuellos de botella complejos.

### Java agent sin tocar código

Te da valor rápido.

Pero no reemplaza:

- modelado de telemetría funcional,
- estándares internos,
- ni decisiones de gobernanza.

### Instrumentación manual bien hecha

Es la que más valor produce a medio plazo.

Pero solo después de tener una base estándar y reusable.

## Error conceptual frecuente en equipos Java

Pensar que observabilidad es una librería que “se instala” y ya está.

No. En Java, como en cualquier stack, observabilidad es una capacidad emergente de varias capas:

- código,
- framework,
- runtime,
- collector,
- backend,
- dashboards,
- alertas,
- y prácticas del equipo.

## Criterio práctico para no complicarte demasiado

Si estás empezando en un equipo Java, prioriza esta secuencia:

1. **métricas + health + logs estructurados**,
2. **trazas distribuidas por auto-instrumentación**,
3. **instrumentación de negocio en los flujos críticos**,
4. **control de coste y ruido**.

Ese orden suele rendir mejor que empezar diseñando dashboards gigantes o spans excesivamente detallados desde el día uno.

## Cierre

Hoy, en Java, la conversación madura de observabilidad no gira alrededor de “qué vendor compro primero”, sino de cómo usar un camino bastante consolidado:

- Spring Boot para la aplicación,
- Micrometer/Actuator para la capa de observación del ecosistema Spring,
- OpenTelemetry para estandarizar telemetría,
- OTLP y Collector para desacoplar,
- y una disciplina de equipo para que los datos emitidos sean útiles.

Esa combinación ya no es exotismo. Es una base bastante razonable para sistemas Java modernos.
