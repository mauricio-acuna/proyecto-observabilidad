# Matriz de stacks Java/microservicios

## Idea central

No todo lo que suena fuerte en redes o conferencias es baseline real. Conviene separar:

- lo **ampliamente estándar hoy**,
- lo **frecuente pero dependiente del contexto**,
- y lo **emergente o situacional**.

Ese filtro importa mucho más que memorizar nombres.

## Matriz resumida

| Componente | Qué tan común es hoy | Veredicto práctico |
|---|---|---|
| Java 17/21 | Muy común | Base moderna razonable |
| Spring Boot | Muy común | Dominante en apps empresariales Java |
| Docker | Muy común | Prácticamente baseline |
| Kubernetes | Muy común en microservicios medianos/grandes | Muy importante, pero no universal |
| PostgreSQL | Muy común | Opción muy estándar |
| OAuth2 / OIDC | Muy común | Conocimiento casi obligatorio |
| OpenTelemetry | Muy común y consolidándose como estándar | Muy recomendable aprenderlo |
| Micrometer + Actuator | Muy común en Spring | Baseline para observabilidad en Spring |
| Testcontainers | Muy común en equipos maduros | Muy rentable para pruebas reales |
| Kafka | Frecuente, no universal | Úsalo por necesidad, no por moda |
| Redis | Frecuente | Muy habitual para caché y casos concretos |
| Spring Security | Muy común | Parte normal del stack |
| GitHub Actions / GitLab CI / Jenkins | Muy común | Cambia la herramienta, no la necesidad |
| Helm / Kustomize | Frecuente en Kubernetes | Útiles si operas en K8s |
| Argo CD / Flux (GitOps) | Creciente | Importante si tu org opera fuerte en Kubernetes |
| GraalVM Native Image | Situacional | Interesante, no baseline general |
| Spring Modulith | Creciente pero situacional | Valioso para monolitos/modularidad, no universal |
| Virtual Threads | En adopción creciente | Relevante conocerlos ya |
| Spring AI | Real y serio, pero no baseline | Aprenderlo depende del tipo de producto |

## Qué sí es muy estándar hoy

## 1. Spring Boot

Sigue siendo la opción dominante para construir aplicaciones Java productivas, especialmente en backend empresarial y microservicios.

Por qué importa:

- configuración opinionated,
- integración fuerte con el ecosistema Spring,
- productividad alta,
- soporte operativo maduro.

Conclusión: no es hype; es base real.

## 2. Java moderno

En muchas organizaciones conviven Java 17 y Java 21. Java 21 tiene cada vez más peso como referencia moderna cuando la organización ya pudo actualizar.

Conclusión: conocer Java “moderno” ya no es opcional si quieres estar alineado con stacks actuales.

## 3. Docker

Sigue siendo casi baseline para empaquetado y despliegue.

Conclusión: quien trabaja en backend moderno debería moverse cómodo con contenedores.

## 4. Kubernetes

Muy importante, pero no universal.

Matiz importante: en entornos medianos y grandes de microservicios aparece muchísimo; en equipos pequeños, productos más simples o entornos menos cloud-native, puede no estar.

Conclusión: conviene entenderlo bien, pero sería exagerado venderlo como presente en literalmente todo proyecto Java.

## 5. PostgreSQL

Es una de las bases de datos más comunes y seguras como elección por defecto.

Conclusión: aprender bien PostgreSQL rinde mucho más que perseguir bases “de moda” sin necesidad.

## 6. OAuth2 / OIDC

En sistemas empresariales y APIs modernas, autenticación y autorización basadas en OAuth2/OIDC son extremadamente comunes.

Conclusión: no basta con “usar Spring Security”; conviene entender estos protocolos.

## 7. Observabilidad con Micrometer y OpenTelemetry

En Spring, Micrometer y Actuator forman parte del camino natural. Y OpenTelemetry se consolidó como estándar transversal de telemetría.

Conclusión: esto sí es conocimiento con retorno real en mercado.

## 8. Testcontainers

Se volvió una práctica muy fuerte para pruebas de integración reales, especialmente cuando quieres probar con PostgreSQL, Kafka, Redis u otros componentes cercanos a producción.

Conclusión: tiene mucho más valor práctico que buena parte del ruido alrededor de testing “elegante” pero poco realista.

## Qué es frecuente, pero depende del caso

## Kafka

Es muy común, pero no debería presentarse como obligatorio.

Tiene sentido cuando necesitas:

- asincronía real,
- integración desacoplada,
- procesamiento orientado a eventos,
- resiliencia en flujos no síncronos.

No tiene sentido meterlo porque “todo stack moderno lo lleva”.

## Redis

Muy habitual para:

- caché,
- locks distribuidos,
- sesiones,
- rate limiting,
- estructuras temporales.

Muy útil, pero no necesariamente el primer componente a introducir.

## Kubernetes toolchain adicional

Herramientas como:

- Helm,
- Kustomize,
- Argo CD,
- Flux,
- service mesh,

aparecen mucho cuando la complejidad operativa sube. No todas son baseline universal.

## Lo emergente o situacional

## Virtual Threads

Son importantes y conviene conocerlos porque cambian la conversación sobre concurrencia en Java. Pero conocerlos no significa que todos los proyectos ya los estén explotando a fondo.

## Spring Modulith

Muy interesante cuando quieres modularidad fuerte dentro de una aplicación Spring Boot, especialmente si no quieres partir demasiado pronto a microservicios.

No es todavía una pieza base transversal del stack generalista.

## GraalVM Native Image

Tiene valor real en ciertos escenarios:

- arranque rápido,
- menor consumo,
- funciones serverless,
- tiempos estrictos de startup.

Pero exige trade-offs, tooling y debugging más delicados. No es baseline para cualquier backend Java.

## Spring AI

Existe, es serio y tiene soporte/documentación oficial en el ecosistema Spring. Pero presentarlo como si ya fuese parte del stack estándar generalista sería engañoso.

Es relevante si tu producto incorpora casos de uso de IA. Si no, no debería desplazar fundamentos mucho más rentables.

## Qué aprender primero y qué dejar para después

## Alta prioridad

- Java moderno,
- Spring Boot,
- Spring Security,
- JPA/JDBC según contexto,
- PostgreSQL,
- Docker,
- HTTP/API design,
- pruebas de integración,
- observabilidad,
- CI/CD básico.

## Prioridad media

- Kubernetes,
- Kafka,
- Redis,
- OAuth2/OIDC profundo,
- Testcontainers avanzado,
- despliegues cloud.

## Prioridad situacional

- GitOps,
- service mesh,
- GraalVM Native Image,
- Spring Modulith,
- Spring AI,
- platform engineering.

## Conclusión directa

La foto honesta hoy se parece más a esto:

> Spring Boot 3, Java 21 cuando se puede, Docker, Kubernetes en muchos entornos, PostgreSQL, OAuth2/OIDC, observabilidad con Micrometer/OpenTelemetry y Testcontainers como práctica fuerte.

No a esto:

> “Todo proyecto moderno usa IA, event sourcing, service mesh, agentes autónomos y native image”.

La segunda narrativa vende mejor. La primera describe mejor la realidad de la mayoría de equipos productivos.
