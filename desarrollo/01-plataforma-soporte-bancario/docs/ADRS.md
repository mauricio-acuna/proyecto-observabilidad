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

## ADR-004: Migrar persistencia principal a PostgreSQL con Flyway

### Contexto

El proyecto principal debe demostrar persistencia real sin acoplar los casos de uso a JPA.

### Decision

Mantener los puertos `CustomerRepository` y `TicketRepository`, agregar adapters JPA y gobernar el esquema con Flyway.
Los repositorios in-memory quedan disponibles solo con el perfil `in-memory`.

### Consecuencias

- Los casos de uso no cambian al mover la persistencia a PostgreSQL.
- El esquema queda versionado y validado por `ddl-auto: validate`.
- Los tests de integracion con Testcontainers quedan preparados para ejecutarse cuando Docker este disponible.
- El siguiente paso natural es persistir eventos con outbox en la misma transaccion.

## ADR-005: Guardar eventos en outbox antes de publicar a broker

### Contexto

Publicar directamente a un broker desde el caso de uso puede perder eventos si la transaccion de base de datos confirma pero el broker falla, o si el broker confirma y luego falla la persistencia del ticket.

### Decision

El puerto `DomainEventPublisher` usa por defecto un adapter de outbox que guarda `TicketCreated` en `outbox_events` con estado `PENDING`.
El adapter de log queda solo para el perfil `in-memory`.

### Consecuencias

- La creacion del ticket y el evento quedan dentro del mismo limite transaccional.
- El sistema puede reintentar publicacion al broker sin duplicar el ticket.
- Falta implementar el relay que lea `PENDING`, publique a RabbitMQ/Kafka/SQS y marque `PUBLISHED` o `FAILED`.
