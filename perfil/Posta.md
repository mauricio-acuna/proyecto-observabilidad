# Plan rector 2026-2027 para Mauricio

## Decision ejecutiva

El perfil no necesita reinventarse como "AI Engineer", mobile developer ni generalista de moda. La opcion mas segura, rentable y coherente con su historia es:

**Senior Java Backend / Cloud Engineer, especializado en sistemas enterprise criticos, banca/fintech, microservicios, AWS, observabilidad, fiabilidad y costos.**

La inteligencia artificial debe entrar como capacidad integrada al backend, no como cambio de identidad profesional. Es decir:

- Si aparece una oferta Java + IA aplicada, se puede competir solo si hay pruebas reales: proyectos, RAG, embeddings, vector search, seguridad, observabilidad y costos.
- Si no existen esas pruebas, no se debe inventar experiencia. Se presenta como Senior Backend/Cloud con aprendizaje y PoCs recientes de IA aplicada.
- Para llegar fuerte a 2027, el foco principal debe ser backend moderno + cloud + entrevistas internacionales. La IA suma, pero no debe dispersar.

## Veredicto sobre el perfil actual

### Fortalezas reales

- Mas de 10-12 anos en Java enterprise.
- Experiencia en banca, fintech, telco, automocion y sistemas regulados.
- Base fuerte en Spring, Spring Boot, REST APIs, microservicios y SQL.
- Experiencia en empresas con marca: T-Systems, IBM/HSBC, Globant/Technisys, HP.
- Buen encaje natural para roles Senior Backend, Lead Backend, Backend Platform o Cloud Backend.
- Ciudadania UE y residencia en Barcelona: ventaja fuerte para mercado europeo.

### Problema principal

El perfil puede parecer mas "programador que cumple tareas" que "senior que reduce riesgo tecnico". La estrategia debe corregir eso.

El mercado no le paga por explorar tecnologias nuevas. Le paga por:

- mantener sistemas criticos,
- tomar buenas decisiones tecnicas,
- reducir fallos,
- modernizar sin romper,
- operar con observabilidad,
- controlar costos,
- comunicar trade-offs,
- liderar tecnicamente sin vender humo.

## Posicionamiento recomendado

### Titular principal

**Senior Java Backend Engineer | Spring Boot | AWS | Microservices | Banking/Fintech**

### Alternativa para roles mas altos

**Senior Backend / Cloud Engineer | Java, Spring Boot, AWS | Reliable Enterprise Systems**

### Alternativa si se construyen proyectos de IA

**Senior Java Backend Engineer | Cloud Microservices | Applied AI Integration**

### Posicionamientos a evitar

- AI Engineer.
- Fullstack generico.
- Mobile developer.
- Arquitecto visionario.
- Emprendedor tech.
- Java developer a secas.

## Regla de seguridad para el CV

No inventar experiencia. No exagerar herramientas. No decir "produccion" si fue laboratorio.

Si algo fue aprendizaje o proyecto personal, escribirlo como:

> Recent hands-on project: built a Java 21/Spring Boot 3 RAG assistant using PostgreSQL/pgvector, embeddings, structured outputs, tests and observability.

Si algo fue experiencia laboral real, escribirlo como:

> Led backend modernization efforts in enterprise systems using Java, Spring Boot, CI/CD and cloud-native deployment practices.

La diferencia protege la credibilidad.

## Brechas que hay que cerrar antes de 2027

### 1. Java moderno

Debe verse actualizado a:

- Java 17/21.
- Spring Boot 3.
- Spring Framework 6.
- Jakarta migration.
- Virtual threads, al menos conceptualmente.
- Testing con JUnit 5, Mockito, AssertJ y Testcontainers.

### 2. Cloud backend serio

Prioridad AWS:

- IAM.
- ECS/Fargate.
- RDS/PostgreSQL.
- SQS/SNS.
- CloudWatch.
- Cost Explorer/Budgets.
- Secrets Manager.
- CI/CD.

Kubernetes sirve mucho, pero no debe desplazar AWS core.

### 3. Observabilidad y operacion

Esta carpeta de documentos deja una idea clave: observabilidad no es instalar dashboards. Es poder entender rapido que paso, donde paso, a quien afecta y que hacer despues.

Debe dominar:

- logs estructurados,
- metricas,
- trazas,
- correlation id,
- Micrometer,
- Actuator,
- OpenTelemetry,
- Prometheus/Grafana o CloudWatch,
- SLI/SLO,
- alertas accionables,
- control de cardinalidad y costos.

### 4. Arquitectura distribuida

Debe poder explicar:

- APIs REST bien disenadas,
- idempotencia,
- retries,
- timeouts,
- circuit breakers,
- DLQ,
- outbox pattern,
- eventual consistency,
- seguridad OAuth2/OIDC,
- escalabilidad y trade-offs.

### 5. Entrevistas internacionales

El objetivo 2027 depende tanto de comunicar como de saber.

Debe preparar:

- ingles tecnico,
- system design,
- coding medium,
- historias STAR,
- negociacion salarial,
- pitch profesional.

### 6. IA aplicada, solo si aporta al objetivo

Para una oferta Java + IA aplicada, faltan pruebas visibles de:

- LLM APIs.
- Structured outputs.
- Prompt versioning.
- RAG.
- Embeddings.
- Vector databases: pgvector, Qdrant, Pinecone, Weaviate o Azure AI Search.
- Evaluacion de respuestas.
- Seguridad ante prompt injection.
- Observabilidad de IA: latencia, tokens, costo, error rate, retrieval hit rate.
- MCP o tool orchestration, si la oferta lo pide.

Sin eso, el match para IA aplicada es bajo aunque el match Java sea bueno.

## Objetivo 2027

### Objetivo principal

Llegar a enero-marzo de 2027 con opciones reales a roles internacionales Senior Backend / Cloud / Lead Java en el rango aproximado de:

**80K-100K EUR total compensation**, con posibilidad superior si conecta con empresa Tier A.

### Objetivo secundario

Poder competir por roles Java + Applied AI solo desde una posicion honesta:

- senior backend solido,
- proyectos demostrables de IA integrada,
- narrativa clara,
- sin presentarse como ML engineer.

## Roadmap mayo 2026 - enero 2027

## Mayo 2026: ordenar base y CV

### Foco

- Reescribir CV y LinkedIn.
- Corregir errores de nombre, ingles, fechas y seniority.
- Pasar de "Java developer" a "Senior Java Backend / Cloud Engineer".
- Definir 15 historias STAR.

### Entregables

- CV v1 en ingles.
- LinkedIn actualizado.
- Pitch de 90 segundos.
- Lista inicial de 50 empresas objetivo.
- Tabla de evidencias reales por tecnologia.

### Frase de posicionamiento

> I am a Senior Java Backend Engineer with 10+ years of experience in banking, fintech and enterprise systems. My focus is building reliable backend services with Java, Spring Boot, microservices, cloud-native practices and strong production ownership.

## Junio 2026: Java 21 + Spring Boot 3 + testing

### Foco

- Java 17/21.
- Spring Boot 3.
- APIs REST.
- PostgreSQL.
- Flyway.
- JPA con criterio.
- JUnit 5.
- Testcontainers.
- Docker Compose.
- GitHub Actions.

### Proyecto

**production-java-platform**

Servicios minimos:

- customer-service,
- ticket-service,
- audit-service.

Debe incluir:

- Java 21,
- Spring Boot 3,
- PostgreSQL,
- OpenAPI,
- Docker Compose,
- tests de integracion,
- pipeline CI.

### Frase para entrevista

> I updated my hands-on stack to Java 21 and Spring Boot 3 through a production-style backend project with PostgreSQL, integration tests, containers and CI.

## Julio 2026: arquitectura distribuida y observabilidad

### Foco

- API Gateway conceptual o practico.
- Resilience4j.
- timeouts, retries, circuit breakers.
- Micrometer.
- Actuator.
- OpenTelemetry.
- Prometheus/Grafana o CloudWatch.
- logs estructurados.
- correlation id.

### Entregables

- Dashboard basico.
- Trazas entre servicios.
- Logs correlacionados.
- Runbook simple de incidentes.
- 4 system design practicados.

### Frase para entrevista

> I designed a microservices architecture with resilience patterns, distributed tracing, structured logs and dashboards focused on diagnosing production issues faster.

## Agosto 2026: eventos, AWS y operacion

### Foco

- AWS Developer Associate como primera certificacion objetivo.
- ECS/Fargate, RDS, SQS/SNS, CloudWatch, IAM.
- Event-driven architecture.
- DLQ.
- Idempotencia.
- Outbox pattern.
- Cost Explorer y Budgets.

### Entregables

- Flujo asincrono: ticket creado -> evento -> notificacion -> auditoria.
- Reintentos controlados.
- DLQ.
- Idempotencia por eventId.
- Estimacion simple de costos AWS.

### Frase para entrevista

> I implemented an event-driven flow with idempotent consumers, retries, DLQ and a clear separation between business transactions and event publication.

## Septiembre 2026: salir al mercado

### Foco

- Aplicar sin esperar perfeccion.
- Practicar recruiter calls.
- Medir respuesta del mercado.
- Ajustar CV segun feedback.

### Actividad minima

- 30-40 aplicaciones.
- 10-15 contactos recruiters.
- 5 contactos directos a hiring managers.
- 2 referrals buscados.
- 10 coding problems.
- 2 system designs.

### Mensaje recruiter

Hi [Name],

I am a Senior Java Backend Engineer with 10+ years of experience in banking, fintech and enterprise systems, including work with IBM/HSBC, T-Systems and Globant/Technisys. My background is focused on Java, Spring Boot, microservices, CI/CD and cloud-native backend systems.

I am currently exploring senior backend or cloud backend roles in international product companies. I am based in Barcelona and hold EU citizenship, so hiring is straightforward.

Would it make sense to connect for a short conversation?

Best,
Mauricio

## Octubre 2026: system design senior

### Foco

- Arquitectura de pagos.
- Sistemas de auditoria.
- High-volume notification system.
- Distributed rate limiter.
- Monitoring platform.
- Search/autocomplete.

### Entregables

- 8 system designs documentados.
- 2 mocks grabados.
- 10 historias STAR refinadas.
- CV v2.

### Senales senior que debe repetir

- "The main trade-off is..."
- "The failure mode is..."
- "I would observe this through..."
- "I would not build this initially because..."
- "The migration path would be..."
- "I would validate the assumption by..."

## Noviembre 2026: IA aplicada como complemento

### Foco

Solo si no interfiere con entrevistas y mercado.

- LLM APIs.
- Structured outputs.
- Prompt versioning.
- Rate limits.
- Cost control.
- Fallback provider.
- Logging seguro.
- Evaluacion basica.

### Proyecto opcional

**ai-support-assistant**

Funcionalidad:

- clasificar tickets,
- extraer entidades,
- resumir caso,
- sugerir respuesta,
- devolver JSON estructurado,
- medir latencia y costo,
- tests con WireMock,
- observabilidad basica.

### Frase segura

> I have been building hands-on applied AI backend projects focused on structured outputs, cost control, observability and safe integration patterns. I do not position myself as an ML engineer; my value is integrating AI capabilities into reliable backend systems.

## Diciembre 2026: segunda ola y cierre de brechas

### Foco

- Reforzar entrevistas falladas.
- Mejorar ingles tecnico.
- Cerrar gaps de AWS.
- Preparar negociacion.
- Enviar segunda ola de aplicaciones.

### Entregables

- CV v3.
- LinkedIn v2.
- 20 historias STAR.
- 30 nuevas aplicaciones.
- 5 referrals.
- AWS Developer Associate programada o aprobada.

## Enero 2027: cierre agresivo

### Foco

- Reactivar procesos.
- Priorizar empresas Tier A y B.
- Mantener pipeline abierto.
- No aceptar primera oferta baja sin negociar.

### Criterios para aceptar

Aceptar si cumple la mayoria:

- 80K EUR TC o mas, idealmente.
- Rol senior real.
- Stack moderno.
- Buen nivel de ingles/exposicion internacional.
- Marca profesional mejor que la actual.
- Crecimiento hacia Backend Architect, Senior Cloud Engineer o Applied AI Backend.
- On-call razonable.
- Cultura tecnica sana.

## Proyecto principal recomendado

## Production-grade Java Microservices Platform

Este proyecto es mas importante que acumular cursos.

### Objetivo

Demostrar que el perfil esta actualizado y que puede construir y operar un backend moderno.

### Stack

- Java 21.
- Spring Boot 3.
- PostgreSQL.
- Kafka o RabbitMQ, o AWS SQS/SNS.
- Redis opcional.
- Docker Compose.
- OpenAPI.
- JUnit 5.
- Testcontainers.
- GitHub Actions.
- Micrometer.
- OpenTelemetry.
- Prometheus/Grafana o CloudWatch.

### Servicios

- customer-service.
- ticket-service.
- notification-service.
- audit-service.

### Features obligatorias

- REST APIs.
- Validacion.
- Manejo global de errores.
- Autenticacion basica o JWT.
- Eventos.
- Outbox pattern.
- Consumidores idempotentes.
- DLQ.
- Logs estructurados.
- Trazas distribuidas.
- Metricas.
- Tests.
- README profesional.
- Diagramas simples C4.
- ADRs con decisiones tecnicas.

### Como venderlo

> I built a production-style Java 21/Spring Boot 3 microservices platform with event-driven communication, PostgreSQL, idempotent consumers, observability, CI/CD and documented architecture decisions. The goal was to modernize my hands-on stack while leveraging my previous enterprise banking experience.

## Proyecto IA opcional para roles Java + IA

## RAG Knowledge Assistant

Hacerlo solo despues de tener el proyecto principal avanzado.

### Caso de uso

Asistente para consultar documentacion interna de banca, soporte o procedimientos operativos.

### Funcionalidad

- subir documentos,
- extraer texto,
- partir en chunks,
- generar embeddings,
- guardar en pgvector o Qdrant,
- busqueda semantica,
- busqueda hibrida si es posible,
- construir prompt con contexto,
- responder con citas,
- rechazar preguntas sin evidencia,
- medir calidad con dataset pequeno de preguntas/respuestas.

### Stack recomendado

- Java 21.
- Spring Boot 3.
- Spring AI.
- PostgreSQL + pgvector o Qdrant.
- OpenAI/Azure OpenAI/Bedrock segun disponibilidad.
- Docker Compose.
- REST API.
- Tests.
- Observabilidad de costo, tokens, latencia y errores.

### Frase para entrevista

> I designed a RAG pipeline covering document ingestion, chunking, embeddings, vector storage, retrieval, context assembly, answer generation with citations and basic evaluation.

## Certificaciones y formacion

### Camino recomendado

1. AWS Certified Developer - Associate.
2. AWS Certified Solutions Architect - Associate.
3. AWS Certified DevOps Engineer - Professional, solo si el camino profesional lo justifica.

### Que no priorizar

- Diplomaturas generalistas de IA.
- Bootcamps fullstack.
- Mobile como eje principal.
- IoT como eje principal.
- Cursos largos sin proyecto demostrable.

### Criterio

Una certificacion o curso solo vale si alimenta el posicionamiento:

**Java + Spring Boot + AWS + sistemas confiables + observabilidad + costos + entrevistas.**

## CV: cambios obligatorios

### Corregir ya

- Nombre: "Mauricio", no variantes mal escritas.
- Ingles: "Advanced", no "Advance".
- Evitar frases genericas como "I love challenges".
- Corregir fechas y anos de experiencia por tecnologia.
- No poner Java 8/Spring Boot como 1 ano si la experiencia muestra mas.
- Reducir tecnologias antiguas: JSF, Struts, Java 6, WebLogic, SunONE.

### Agregar arriba del CV

**Summary**

Senior Java Backend Engineer with 10+ years of experience building enterprise systems in banking, fintech and regulated environments. Strong background in Java, Spring Boot, REST APIs, microservices, SQL databases, CI/CD and cloud-native practices. Focused on reliable backend architecture, production ownership, observability, maintainability and technical leadership.

### Core stack

- Backend: Java 17/21, Spring Boot 3, Spring Framework, REST APIs, JPA/Hibernate.
- Cloud/DevOps: AWS, Docker, Kubernetes/OpenShift, CI/CD, GitHub Actions/Jenkins/Bamboo.
- Data: PostgreSQL, Oracle, SQL Server, DB2, MongoDB, DynamoDB.
- Reliability: OpenTelemetry, Micrometer, Actuator, structured logs, dashboards, incident analysis.
- Quality: JUnit 5, Mockito, Testcontainers, SonarQube, code reviews.
- Architecture: microservices, event-driven architecture, resilience patterns, API design.

Solo incluir cada punto si puede defenderlo.

## Entrevistas

## Coding

### Estructura verbal

1. Let me restate the problem.
2. What are the constraints?
3. Can I assume the input fits in memory?
4. I will start with a brute-force approach.
5. We can optimize this using...
6. The time complexity is...
7. Let me test it with edge cases.

### Objetivo minimo

- 150-250 problemas antes de enero 2027.
- Foco en arrays, strings, maps, intervals, heaps, trees, graphs y DP basica.
- Explicar en ingles, no solo resolver.

## System design

### Apertura estandar

> Let me clarify the requirements first. I will separate functional and non-functional requirements, then propose a high-level architecture, discuss data models and APIs, and finally go deeper into scalability, reliability, security, observability and trade-offs.

### Checklist

- Requirements.
- Traffic estimation.
- APIs.
- Data model.
- Components.
- Storage.
- Cache.
- Queue/events.
- Scaling.
- Consistency.
- Failure handling.
- Security.
- Observability.
- Cost.

## Behavioral

Preparar historias sobre:

- desacuerdo tecnico,
- incidente productivo,
- mentoring,
- fallo propio,
- ambiguedad,
- mejora de calidad,
- influencia sobre stakeholders,
- deuda tecnica,
- trade-off,
- entrega bajo presion.

### Estructura STAR mejorada

- Situation.
- Task.
- Action.
- Trade-off.
- Result.
- Learning.

## Estrategia salarial

### No anclar bajo

No empezar diciendo que acepta 65K-70K si el objetivo real es superior.

### Frase recomendada

> For senior backend roles in international product companies, I am targeting around 90K-110K EUR total compensation, depending on level, scope, bonus, equity, remote policy and on-call expectations.

Si necesita ser mas conservador:

> I am flexible depending on the full package and role scope, but for senior backend roles I am mainly looking at opportunities from around 80K EUR total compensation.

## Estrategia de aplicaciones

### Tier A

Objetivo: 90K-130K TC.

- Big Tech.
- Scaleups internacionales.
- Fintechs fuertes.
- SaaS B2B.
- Infra/platform companies.
- Remote-first.

### Tier B

Objetivo: 75K-95K TC.

- Producto europeo.
- Fintech mediana.
- SaaS con cultura engineering seria.
- Hubs internacionales en Espana.

### Tier C

Objetivo: 65K-80K.

- Consultoras premium.
- Bancos con stack moderno.
- Empresas espanolas con rol lead.

No empezar por Tier C salvo para practica. Usarlas como fallback, no como ancla mental.

## Metricas semanales

Cada domingo completar:

| Metrica | Objetivo |
|---|---:|
| Horas totales | 12-18 |
| Coding problems | 8-12 |
| System designs | 1-2 |
| Ingles grabado | 4-5 sesiones |
| Mock interviews | 1 |
| Historias STAR mejoradas | 2 |
| Aplicaciones desde septiembre | 10-20 |
| Contactos recruiter desde septiembre | 5-10 |

## Score mensual

Puntuar de 1 a 5:

- Coding.
- System design.
- Ingles.
- Behavioral.
- CV/LinkedIn.
- AWS/cloud.
- Observabilidad.
- Networking.
- Negociacion.

Si una categoria queda por debajo de 3 durante dos meses, corregirla con prioridad.

## Riesgos reales

### Riesgo 1: estudiar mucho y aplicar poco

Correccion: desde septiembre 2026 aplicar aunque no este perfecto.

### Riesgo 2: dispersarse con IA

Correccion: IA entra como integracion backend, no como identidad principal.

### Riesgo 3: sobreestimar el ingles

Correccion: grabarse explicando system design durante 30-45 minutos.

### Riesgo 4: CV con seniority pero sin impacto

Correccion: cada experiencia debe mostrar decisiones, criticidad, escala, equipo, impacto o mejora.

### Riesgo 5: venderse como lead y responder como developer

Correccion: hablar de riesgos, trade-offs, sistemas, personas, incidentes y resultados.

### Riesgo 6: perseguir herramientas sin criterio

Correccion: priorizar fundamentos con retorno: Java moderno, Spring Boot, AWS, observabilidad, seguridad, testing, entrevistas.

## Resultado esperado al 31 de enero de 2027

Si se ejecuta con disciplina razonable:

- CV internacional fuerte.
- LinkedIn coherente.
- Ingles suficiente para entrevistas preparadas.
- Proyecto Java moderno demostrable.
- 150-250 coding problems acumulados.
- 30-50 system designs practicados.
- 20 historias STAR listas.
- 80-150 aplicaciones dirigidas.
- 20-40 conversaciones con recruiters.
- 5-15 procesos serios.
- Probabilidad real de oferta en 80K-100K TC.
- Mejor posicion para roles Senior Backend, Cloud Backend, Lead Backend o Backend Platform.

## Cierre

La estrategia correcta no es cambiar de tecnologia por ansiedad. Es ordenar el perfil alrededor de aquello por lo que el mercado ya paga bien:

**Java backend senior, sistemas confiables, cloud, observabilidad, operacion, costos y criterio tecnico.**

La IA puede potenciar ese perfil, pero no debe reemplazarlo. El objetivo 2027 se logra con foco, evidencia y aplicacion al mercado, no acumulando diplomaturas ni persiguiendo cada tendencia.
