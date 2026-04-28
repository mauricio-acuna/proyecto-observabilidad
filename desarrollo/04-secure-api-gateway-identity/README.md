# Secure API Gateway & Identity

## Problema real que resuelve

Una plataforma con varios servicios necesita exponer APIs de forma segura, controlar acceso, aplicar rate limiting, centralizar trazabilidad y evitar duplicar logica transversal en cada servicio.

## Capacidades funcionales

- Gateway de entrada.
- Validacion JWT.
- Integracion OAuth2/OIDC.
- Rate limiting por cliente.
- Propagacion de correlation ID.
- Auditoria de requests sensibles.
- Reglas de acceso por rol.
- Circuit breaker hacia servicios internos.

## Stack aplicado

- Java 21.
- Spring Boot 3.
- Spring Cloud Gateway.
- Spring Security.
- OAuth2/OIDC.
- JWT.
- Redis para rate limiting.
- Resilience4j.
- OpenTelemetry.
- WireMock.
- Docker Compose.

## Patrones y soluciones

- API Gateway.
- Authentication vs authorization.
- Token propagation.
- Rate limiting.
- Circuit breaker.
- Timeout.
- Fail fast.
- Zero trust conceptual.
- Least privilege.
- Audit logging.

## Diseno sugerido

Componentes:

- `api-gateway`
- `identity-provider` simulado con Keycloak o mock.
- `customer-service`
- `ticket-service`

## Que se puede defender en entrevista

- Por que centralizar ciertas politicas en gateway.
- Que no deberia hacer un gateway.
- Diferencia entre OAuth2, OIDC y JWT.
- Como proteger APIs internas.
- Como observar errores 401/403/429/5xx.
- Como manejar degradacion cuando un servicio interno falla.

## Entregables

- Gateway funcional.
- Configuracion de seguridad.
- Rate limiting.
- Tests con WireMock.
- Dashboard de trafico por status.
- ADR de seguridad.

