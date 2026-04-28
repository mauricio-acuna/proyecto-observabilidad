# Fundamentos de observabilidad

## Qué es observabilidad

Una definición útil y ampliamente aceptada es esta: observabilidad es la capacidad de entender el estado interno de un sistema a partir de sus salidas externas.

Esa definición importa porque desplaza el foco desde “qué herramienta instalé” hacia “qué tan bien puedo explicar lo que está pasando cuando algo falla, degrada o se comporta de manera extraña”.

En un sistema simple esto parece trivial. En sistemas distribuidos no lo es.

## Monitorización y observabilidad no son sinónimos

Se parecen, pero no son lo mismo.

### Monitorización

La monitorización suele responder mejor a preguntas conocidas:

- ¿la CPU está alta?
- ¿la latencia superó cierto umbral?
- ¿hay más errores 500 de lo normal?

Funciona muy bien cuando ya sabes qué mirar.

### Observabilidad

La observabilidad intenta responder también preguntas que no habías previsto por completo:

- ¿qué servicio introdujo la regresión?
- ¿por qué un subconjunto de usuarios falla solo en cierto flujo?
- ¿qué dependencia externa está explicando un pico de latencia?

La observabilidad no elimina la monitorización. La engloba y la extiende.

## Las tres señales clásicas

En la práctica moderna se sigue hablando de tres pilares o tres señales principales.

## 1. Logs

Los logs registran eventos discretos que ocurrieron en un instante o contexto concreto.

Ejemplos:

- una excepción,
- un login fallido,
- una llamada HTTP con error,
- una transición de estado relevante.

### Qué aportan

- detalle textual,
- contexto fino,
- evidencia puntual,
- secuencia de eventos.

### Qué problema tienen

Sin estructura ni correlación, los logs degradan rápido en ruido.

Buenas prácticas mínimas:

- formato estructurado, idealmente JSON,
- campos consistentes,
- niveles de severidad con criterio,
- sin volcar secretos,
- con identificadores de correlación.

## 2. Métricas

Las métricas son medidas numéricas agregables a lo largo del tiempo.

Ejemplos:

- tasa de peticiones,
- latencia p95,
- uso de memoria,
- número de errores por endpoint,
- mensajes pendientes en una cola.

### Qué aportan

- visión agregada,
- tendencias,
- alertas,
- detección rápida de anomalías.

### Qué problema tienen

Son excelentes para ver que algo va mal, pero muchas veces no bastan para explicar por qué.

## 3. Trazas

Las trazas representan el recorrido de una petición o transacción a través de varios componentes.

Una traza se compone de **spans**, y cada span representa una operación con:

- inicio y fin,
- duración,
- atributos,
- relación con otros spans.

### Qué aportan

- causalidad,
- dependencia entre servicios,
- breakdown de latencia,
- visualización del recorrido de una request.

### Qué problema tienen

Si se instrumentan mal o se muestrean sin criterio, pueden resultar costosas o poco representativas.

## La clave real: correlación

Tener las tres señales por separado ayuda. Tenerlas correlacionadas cambia el juego.

Ejemplo:

- una métrica avisa de aumento en la latencia,
- una traza muestra que el cuello de botella está en una llamada a otro servicio,
- un log asociado al mismo trace id revela el timeout exacto.

Eso reduce muchísimo el tiempo de diagnóstico.

## Contexto y propagación

En sistemas distribuidos, una parte crítica de la observabilidad es propagar contexto entre procesos.

Ese contexto suele incluir, entre otros:

- trace id,
- span id,
- baggage o metadatos de contexto,
- identificadores funcionales relevantes.

Si el contexto no viaja bien entre servicios, colas o procesos asíncronos, la trazabilidad se rompe.

## Cardinalidad: concepto pequeño, impacto enorme

La cardinalidad es el número de valores distintos que puede tomar una etiqueta o atributo.

Ejemplos:

- `status=200|500` tiene baja cardinalidad,
- `userId=...` suele tener cardinalidad muy alta,
- `requestId=...` es altísima cardinalidad.

### Por qué importa

En métricas, una cardinalidad descontrolada puede disparar:

- consumo de almacenamiento,
- presión en consultas,
- coste,
- e incluso degradación de la plataforma de observabilidad.

No todo dato útil debe ser etiqueta de métrica. A veces corresponde a log o a atributo de traza, no a una dimensión agregable.

## Telemetría: el término paraguas

Telemetría es el conjunto de datos emitidos por un sistema para describir su comportamiento.

Incluye normalmente:

- logs,
- métricas,
- trazas,
- y cada vez más eventos o perfiles, según la plataforma.

Hablar de telemetría ayuda a pensar el sistema de observabilidad como una cadena completa:

1. generación,
2. transporte,
3. procesamiento,
4. almacenamiento,
5. consulta,
6. uso operativo.

## Instrumentación

Instrumentar es añadir capacidad para emitir telemetría.

Puede ser:

### Automática

Por ejemplo, un agente que detecta librerías comunes y genera spans o métricas sin tocar mucho código.

Ventaja: rapidez.

Límite: normalmente captura muy bien lo técnico, pero peor lo funcional o de negocio.

### Manual

El equipo añade spans, eventos, atributos y métricas en puntos elegidos del código.

Ventaja: control y semántica.

Límite: requiere criterio y disciplina.

En la práctica, lo mejor suele ser mezcla de ambas.

## Señales técnicas vs señales de negocio

Un error frecuente es quedarse solo con señales técnicas.

Ejemplos técnicos:

- CPU,
- heap,
- GC,
- latencia HTTP,
- conexiones a base de datos.

Ejemplos de negocio:

- pedidos creados por minuto,
- ratio de pago fallido,
- tiempo de checkout,
- tasa de conversión de un flujo.

Las señales técnicas te dicen si el sistema sufre. Las de negocio te dicen si el sistema está cumpliendo su propósito.

## SLI, SLO y SLA

Estos tres términos suelen mezclarse mal.

### SLI

Service Level Indicator. Es una medida concreta del comportamiento del servicio.

Ejemplo:

- porcentaje de requests completadas con éxito,
- latencia p95 de un endpoint clave.

### SLO

Service Level Objective. Es el objetivo definido sobre uno o varios SLI.

Ejemplo:

- 99.9% de requests exitosas en 30 días,
- p95 menor a 300 ms para checkout.

### SLA

Service Level Agreement. Es un compromiso formal, normalmente contractual.

No todos los equipos necesitan SLA. Sí necesitan, en cambio, algún nivel de SLI/SLO si quieren operar con criterio.

## Alertas: menos cantidad, más calidad

Una mala cultura de alertado arruina incluso una buena instrumentación.

Malas alertas:

- demasiado sensibles,
- sin contexto,
- basadas en síntomas irrelevantes,
- imposibles de accionar.

Buenas alertas:

- conectadas con impacto real,
- con umbrales razonables,
- con runbooks o pistas de diagnóstico,
- preferiblemente alineadas con SLO.

## Observabilidad no arregla un mal sistema

También conviene corregir una exageración habitual: observabilidad no compensa una arquitectura mala, una gestión de errores deficiente o un dominio mal modelado.

Ayuda a entender problemas. No reemplaza:

- diseño correcto,
- testing serio,
- despliegues seguros,
- ownership,
- ni disciplina operativa.

## Qué cambia con microservicios

En monolitos sencillos podías depurar muchas cosas con logs y conocimiento local.

En microservicios aparecen dificultades nuevas:

- latencia distribuida,
- fallos parciales,
- reintentos,
- colas,
- timeouts encadenados,
- ownership repartido,
- y dependencia de infraestructura dinámica.

Ahí la observabilidad deja de ser “nice to have” y pasa a ser una capacidad operativa básica.

## Resumen operativo

Qué conviene fijar bien:

- **Logs**: detalle puntual.
- **Métricas**: visión agregada y alertado.
- **Trazas**: recorrido y causalidad.
- **Correlación**: lo que une todo.
- **Instrumentación**: cómo generas la telemetría.
- **Cardinalidad**: uno de los grandes puntos de coste y diseño.
- **SLI/SLO**: forma seria de conectar observabilidad con servicio real.

## Cierre

La pregunta correcta no es “¿tenemos observabilidad?”.

La pregunta correcta es:

> Cuando algo sale mal, ¿podemos entender con rapidez qué pasó, dónde pasó, a quién afecta y qué hacer después?

Si la respuesta es no, entonces aún no tienes una capacidad de observabilidad suficientemente madura, aunque tengas muchas herramientas instaladas.
