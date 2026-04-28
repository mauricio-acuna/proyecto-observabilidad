# Guia de implementacion

## Objetivo

Cada proyecto de `desarrollo` debe tener una estructura suficiente para demostrar:

- problema real,
- decisiones de arquitectura,
- codigo fuente inicial,
- interfaces,
- puertos/adaptadores,
- documentacion de conceptos aplicados,
- puntos de extension para completar la implementacion.

## Estructura base por proyecto

```text
pom.xml
README.md
docs/
  CONCEPTOS_APLICADOS.md
  ADRS.md
src/
  main/
    java/com/proyecto2027/<proyecto>/
      <Proyecto>Application.java
      domain/
      application/
      infrastructure/
  test/
    java/com/proyecto2027/<proyecto>/
```

## Criterio de arquitectura

Se usa una variante simple de arquitectura hexagonal:

- `domain`: entidades, value objects y eventos de dominio.
- `application`: casos de uso y puertos.
- `infrastructure`: REST controllers, persistencia, mensajeria, integraciones externas y observabilidad.

La estructura no busca sobredisenar. Busca que cada decision pueda explicarse en entrevista:

> Esta interfaz separa el caso de uso del detalle tecnologico. Asi puedo probar la logica sin depender de base de datos, broker, proveedor cloud o API externa.

## Convenciones

- Java 21 como referencia.
- Spring Boot 3 como framework base.
- REST para APIs externas.
- Puertos para dependencias externas.
- In-memory adapters cuando el proyecto aun no necesita infraestructura real.
- Documentacion explicita de patrones y trade-offs.

## Nivel esperado

No todos los proyectos tienen que convertirse en productos completos. La cartera se divide asi:

- Proyectos 01-04: deben poder evolucionar a implementacion completa.
- Proyectos 05-08: PoCs tecnicos fuertes y defendibles.
- Proyectos 09-12: escenarios especializados para entrevistas senior.

