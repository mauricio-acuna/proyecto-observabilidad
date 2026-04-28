# Conceptos aplicados

## Monolito modular

`customers` y `tickets` estan separados por API interna, no por acceso directo a clases internas.

## Migracion gradual

`CustomerModuleApi` permite reemplazar el modulo de clientes por llamada HTTP/evento cuando se extraiga a microservicio.

## Strangler Fig pattern

El proyecto permite explicar extraccion progresiva, no big bang.

## Conceptos del perfil que cubre

- Modularidad.
- Migracion legacy.
- Microservicios con criterio.
- Bounded contexts.
- Reduccion de riesgo.

