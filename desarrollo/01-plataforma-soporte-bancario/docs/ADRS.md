# ADRs iniciales

## ADR-001: Usar arquitectura hexagonal ligera

### Contexto

El proyecto debe mostrar criterio senior sin sobredisenar.

### Decision

Separar dominio, casos de uso, puertos e infraestructura.

### Consecuencias

- La logica se puede probar sin levantar infraestructura.
- Los adaptadores pueden reemplazarse por PostgreSQL, Kafka o AWS sin cambiar el caso de uso.
- Hay mas archivos que en un CRUD simple, pero mejor conversacion tecnica.

## ADR-002: Empezar con adaptadores in-memory

### Contexto

La prioridad inicial es mostrar arquitectura y flujo funcional.

### Decision

Usar repositorios in-memory y adapters de log.

### Consecuencias

- Permite avanzar rapido.
- No reemplaza la persistencia real.
- El siguiente paso sera PostgreSQL + Flyway + outbox.

## ADR-003: Publicar evento al abrir ticket

### Contexto

Abrir un ticket no debe depender de que funcionen notificaciones o integraciones externas.

### Decision

Modelar `TicketCreatedEvent` y publicarlo desde el caso de uso.

### Consecuencias

- Se habilita comunicacion asincrona.
- Aparece necesidad de idempotencia y DLQ en consumidores.
- Permite explicar event-driven architecture.

