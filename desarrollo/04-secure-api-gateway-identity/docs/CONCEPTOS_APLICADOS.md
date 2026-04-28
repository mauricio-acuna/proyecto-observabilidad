# Conceptos aplicados

## API Gateway

Centraliza entrada, seguridad y propagacion de contexto.

## OAuth2/OIDC/JWT

`SecurityConfig` configura el gateway como resource server. La validacion real depende de un issuer configurado.

## Correlation ID

`CorrelationIdFilter` agrega o propaga `X-Correlation-Id` para diagnostico distribuido.

## Rate limiting

Siguiente paso: agregar Redis Rate Limiter de Spring Cloud Gateway.

## Conceptos del perfil que cubre

- Seguridad API.
- Gateway.
- OAuth2/OIDC.
- JWT.
- Observabilidad.
- Propagacion de contexto.
- Arquitectura de microservicios.

