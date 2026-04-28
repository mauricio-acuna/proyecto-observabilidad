# Platform Engineering Service Template

## Problema real que resuelve

Cuando cada equipo crea microservicios desde cero, aparecen inconsistencias en estructura, seguridad, observabilidad, CI/CD y despliegue. Este proyecto crea un template productivo para reducir carga cognitiva.

## Capacidades funcionales

- Template de microservicio Spring Boot.
- Estructura de paquetes estandar.
- Seguridad base.
- Observabilidad lista.
- Testing base.
- Pipeline CI.
- Dockerfile.
- Helm/Kubernetes opcional.
- ADRs iniciales.

## Stack aplicado

- Java 21.
- Spring Boot 3.
- Spring Security.
- Actuator.
- Micrometer.
- OpenTelemetry.
- Docker.
- GitHub Actions.
- Kubernetes manifests o Helm.
- Testcontainers.

## Patrones y soluciones

- Platform Engineering.
- Golden path.
- Developer experience.
- Service template.
- Estandares internos.
- Shift-left testing.
- Observabilidad por defecto.
- Seguridad por defecto.

## Diseno sugerido

Contenido:

- `template-service`
- `docs/adr`
- `docs/runbook.md`
- `.github/workflows`
- `docker`
- `k8s`
- `observability`

## Que se puede defender en entrevista

- Que es Platform Engineering.
- Como reducir variabilidad entre equipos.
- Como crear un golden path sin bloquear autonomia.
- Que debe traer un microservicio desde el dia cero.
- Como balancear estandarizacion y flexibilidad.

## Entregables

- Template reusable.
- Guia de uso.
- Pipeline.
- Dockerfile.
- Manifiestos.
- Ejemplo de servicio generado.

