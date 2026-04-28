# Modular Monolith to Microservices

## Problema real que resuelve

Muchas organizaciones rompen monolitos demasiado pronto y crean microservicios distribuidos sin limites de dominio claros. Este proyecto demuestra una migracion gradual y segura.

## Capacidades funcionales

- Aplicacion modular con dominios separados.
- Validacion de dependencias entre modulos.
- Eventos internos.
- Extraccion gradual de un modulo a servicio.
- Compatibilidad hacia atras.

## Stack aplicado

- Java 21.
- Spring Boot 3.
- Spring Modulith.
- PostgreSQL.
- Testcontainers.
- OpenAPI.
- Docker Compose.
- Micrometer.

## Patrones y soluciones

- Modular monolith.
- Bounded contexts.
- Domain events.
- Strangler Fig pattern.
- Anti-corruption layer.
- Contract testing conceptual.
- Migracion incremental.
- ADRs de arquitectura.

## Diseno sugerido

Modulos:

- `customers`
- `tickets`
- `billing`
- `notifications`
- `audit`

Extraccion:

1. Identificar limites.
2. Crear API interna.
3. Publicar eventos.
4. Extraer `notifications`.
5. Mantener compatibilidad.

## Que se puede defender en entrevista

- Por que microservicios no siempre son el primer paso.
- Como descubrir limites de dominio.
- Como migrar sin big bang.
- Como reducir riesgo.
- Como decidir que modulo extraer primero.

## Entregables

- Monolito modular funcional.
- Verificacion de dependencias.
- Primer modulo extraido.
- ADRs de migracion.
- Diagrama antes/despues.

