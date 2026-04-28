# Índice

## Paquete 1: Observabilidad para Java desde cero

Este paquete está pensado para alguien que desarrolla en Java y parte prácticamente de cero en observabilidad. La progresión va de lo conceptual a lo operativo:

1. **01-que-es-build-a-smarter-observability-strategy.md**  
   Qué suele querer decir esa expresión, qué parte es lenguaje comercial y qué parte corresponde a prácticas reales.

2. **02-fundamentos-de-observabilidad.md**  
   Conceptos base: logs, métricas, trazas, correlación, contexto, cardinalidad, SLI/SLO y diferencias entre monitorización y observabilidad.

3. **03-observabilidad-para-java.md**  
   Cómo aterriza todo esto en el ecosistema Java moderno, especialmente con Spring Boot, Micrometer y OpenTelemetry.

4. **04-arquitectura-y-stack-tipico.md**  
   Cómo suele verse un stack de observabilidad real en equipos Java: instrumentación, collector, backend y visualización.

5. **05-como-empezar-en-tu-equipo.md**  
   Un plan de adopción incremental, evitando sobreingeniería y costes innecesarios.

6. **06-glosario-rapido.md**  
   Definiciones cortas y operativas para repasar términos.

## Paquete 2: Stacks y roadmap de upgrade para Java/microservicios

Este paquete separa lo que hoy es bastante estándar de lo que está creciendo, pero todavía no es baseline universal.

1. **01-matriz-stacks-java-microservicios.md**  
   Qué tecnologías son hoy comunes, cuáles son opcionales y cuáles dependen mucho del contexto.

2. **02-conceptos-modernos-que-conviene-conocer.md**  
   Platform Engineering, GitOps, Virtual Threads, Spring Modulith, GraalVM Native Image y Spring AI en su justa medida.

3. **03-roadmap-de-upgrade-para-java-dev.md**  
   Una propuesta de aprendizaje por fases para actualizar perfil sin perseguir hype.

## Idea fuerza de ambos paquetes

La idea no es aprender nombres de herramientas, sino entender:

- qué problema resuelve cada pieza,
- qué es estándar hoy,
- qué es opcional,
- y en qué orden tiene sentido aprenderlo.

En Java productivo actual, el baseline razonable suele girar alrededor de:

- **Java 21** como referencia moderna cuando la organización ya pudo actualizar,
- **Spring Boot** como framework dominante para aplicaciones empresariales,
- **Micrometer + Actuator** como entrada natural a observabilidad en el ecosistema Spring,
- **OpenTelemetry** como estándar de telemetría,
- **Docker** y con mucha frecuencia **Kubernetes** en entornos de microservicios,
- **PostgreSQL** como base de datos muy habitual,
- **OAuth2/OIDC** para autenticación/autorización moderna,
- y **Kafka** cuando hay una necesidad real de eventos o asincronía, no por moda.

## Cómo leerlo

- Si vienes de backend Java clásico y observabilidad te suena difuso, empieza por el **paquete 1**.
- Si ya trabajas con Spring Boot y microservicios, puedes leer en paralelo el **paquete 2**.
- Si tu objetivo es empleabilidad, no estudies todos los conceptos con la misma profundidad: prioriza primero lo que ya es estándar y deja para después lo situacional.

## Nota de criterio

En estos documentos se distingue deliberadamente entre:

- **estándar real de mercado**,
- **práctica extendida pero no universal**,
- y **tecnología en crecimiento que todavía no conviene vender como obligatoria**.

Esa distinción importa porque una gran parte del ruido técnico viene de mezclar “existe”, “está creciendo” y “es baseline en la mayoría de equipos” como si fueran lo mismo.
