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

## Configuracion local actual

- Gateway en `localhost:8080`.
- Redis rate limiting en `localhost:6379`.
- Keycloak local en `localhost:8089`.
- Issuer OIDC por defecto: `http://localhost:8089/realms/proyecto2027`.
- Realm importado desde `keycloak/proyecto2027-realm.json`.
- Ruta principal: `/support/**` hacia `01-plataforma-soporte-bancario`.
- La ruta `/support/**` requiere `ROLE_support_user` o `ROLE_support_admin`.

Variables utiles:

```bash
APP_REDIS_HOST=localhost
APP_REDIS_PORT=6379
APP_OIDC_ISSUER_URI=http://localhost:8089/realms/proyecto2027
APP_RATE_LIMIT_REPLENISH_RATE=10
APP_RATE_LIMIT_BURST_CAPACITY=20
```

Token demo:

```bash
curl -X POST http://localhost:8089/realms/proyecto2027/protocol/openid-connect/token \
  -H "Content-Type: application/x-www-form-urlencoded" \
  -d "grant_type=password" \
  -d "client_id=proyecto2027-gateway" \
  -d "username=demo-user" \
  -d "password=demo123"
```

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
- Tests WebFlux para 401, 403 y 429.
- Tests con WireMock.
- Dashboard de trafico por status.
- ADR de seguridad.
