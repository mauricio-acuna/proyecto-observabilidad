# Conceptos modernos que conviene conocer

## Criterio de lectura

Conviene conocer estos conceptos no porque todos sean baseline universal, sino porque están ganando peso real o resuelven problemas concretos en determinados contextos.

El error sería meterlos a todos en el mismo saco.

## 1. Platform Engineering

### Qué es

Platform Engineering gira alrededor de construir herramientas, flujos y capacidades internas que den autoservicio a los equipos de desarrollo.

En términos simples: en vez de obligar a cada equipo a resolver por su cuenta infraestructura, despliegues, observabilidad, secretos, entornos y plantillas operativas, se crea una plataforma interna con buen diseño.

### Cuándo importa

- múltiples equipos,
- necesidad de estandarizar,
- entornos complejos,
- mucho tiempo perdido en tareas repetitivas de operación.

### Qué no es

No es simplemente “el equipo de DevOps con otro nombre”. Si no hay producto interno, autoservicio y reducción de carga cognitiva, la etiqueta queda grande.

### Veredicto

Concepto importante y cada vez más formal en el mundo cloud-native. Merece la pena entenderlo, aunque no todo equipo necesita montar una plataforma interna seria.

## 2. GitOps

### Qué es

GitOps es un conjunto de prácticas donde el estado deseado de aplicaciones e infraestructura se define en Git, y un sistema lo reconcilia continuamente contra el estado real.

### Por qué importa

Aporta:

- trazabilidad,
- auditabilidad,
- consistencia,
- despliegues más gobernables,
- rollback más claro.

### Dónde encaja mejor

Especialmente bien en ecosistemas Kubernetes.

### Qué no conviene exagerar

No todo despliegue con YAML en un repositorio ya es GitOps de verdad. La clave está en la reconciliación declarativa del estado deseado contra el real.

### Veredicto

Muy relevante en organizaciones cloud-native, especialmente con Argo CD o Flux. No es obligatorio para cualquier equipo Java, pero sí cada vez más importante.

## 3. Virtual Threads

### Qué son

Los virtual threads de Java son hilos ligeros gestionados por el runtime, pensados para facilitar aplicaciones concurrentes de alto throughput con un estilo de programación más directo.

### Por qué importan

Porque reducen parte del coste mental y operativo de manejar grandes cantidades de concurrencia con modelos tradicionales.

### Qué no deberías concluir

No significan que todo diseño reactivo o no bloqueante quede automáticamente obsoleto. Tampoco convierten cualquier aplicación en más rápida por arte de magia.

### Veredicto

Muy recomendable conocerlos ya. Aunque su adopción práctica todavía depende del tipo de aplicación, afectan de lleno a la conversación moderna sobre concurrencia en Java.

## 4. Spring Modulith

### Qué es

Spring Modulith es un toolkit opinado para construir aplicaciones Spring Boot modulares, guiadas por módulos funcionales bien definidos.

### Por qué importa

Porque responde a un problema real: muchas aplicaciones que se llaman “monolito” son, en realidad, bloques grandes y desordenados sin fronteras internas claras.

Spring Modulith ayuda a:

- definir módulos,
- verificar límites,
- documentar estructura,
- y observar comportamiento a nivel modular.

### Dónde tiene sentido

- monolitos que necesitan orden fuerte,
- equipos que quieren modularidad antes de partir a microservicios,
- sistemas de dominio complejo.

### Veredicto

No es baseline universal, pero sí una tecnología seria y útil. Conviene conocerla porque ofrece una alternativa mejor que el falso dilema “monolito caótico o microservicios”.

## 5. GraalVM Native Image

### Qué es

Tecnología para compilar aplicaciones Java a binarios nativos, con foco en arranque rápido y menor huella de memoria en ciertos escenarios.

### Cuándo brilla

- funciones serverless,
- microservicios con exigencias fuertes de startup,
- entornos con restricciones de memoria,
- despliegues donde el tiempo de arranque pesa mucho.

### Coste o trade-offs

- build más compleja,
- debugging más delicado,
- compatibilidades a validar,
- tuning específico.

### Veredicto

Importante conocerlo, pero no venderlo como elección por defecto para todo backend Java.

## 6. Spring AI

### Qué es

Spring AI es el framework del ecosistema Spring para construir aplicaciones con capacidades de IA, intentando aplicar principios conocidos del ecosistema Spring al desarrollo con modelos.

### Por qué importa

Porque no es un experimento marginal: tiene proyecto, documentación y evolución oficial dentro del ecosistema Spring.

### Qué sí conviene decir

- es serio,
- es relevante si trabajas en productos con IA,
- probablemente ganará peso.

### Qué no conviene decir

No conviene presentarlo como pieza base del stack Java generalista actual. Hoy sigue siendo situacional respecto al backend empresarial estándar.

### Veredicto

Conviene saber que existe y entender su lugar. Pero no desplaza fundamentos como seguridad, datos, testing, observabilidad o despliegue.

## 7. Observabilidad abierta como estándar de plataforma

Más allá del término “observabilidad”, lo importante hoy es el peso de estándares abiertos como OpenTelemetry dentro de plataformas modernas.

### Por qué importa

Porque ya no es una preocupación exclusiva del equipo SRE. Afecta a:

- bibliotecas,
- servicios,
- pipelines,
- operación,
- gobernanza de costes.

### Veredicto

Esto sí tiene impacto transversal y conviene tratarlo como parte de la base moderna.

## Cómo priorizarlos mentalmente

## Debes conocerlos bien

- Virtual Threads,
- OpenTelemetry/observabilidad moderna,
- nociones de Kubernetes/GitOps si vas a cloud-native.

## Debes saber ubicarlos correctamente

- Platform Engineering,
- Spring Modulith,
- GraalVM Native Image,
- Spring AI.

La diferencia es clave: algunos merecen estudio profundo inmediato; otros, comprensión estratégica para no quedarte fuera de conversación técnica.

## Cierre

Estos conceptos importan, pero no por la misma razón:

- unos ya están modificando prácticas base,
- otros están creciendo como disciplina,
- otros son herramientas potentes pero situacionales.

El criterio maduro no es “aprender todo”.

Es saber **qué es baseline, qué está subiendo y qué depende del contexto**.
