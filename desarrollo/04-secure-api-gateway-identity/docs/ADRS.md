# ADRs iniciales

## ADR-001: Centralizar seguridad de entrada en gateway

### Decision

Validar tokens JWT en el gateway para proteger rutas externas.

### Motivo

Reduce duplicacion de controles transversales y permite auditar accesos en un punto claro.

## ADR-002: Propagar correlation id

### Decision

El gateway garantiza que toda request tenga `X-Correlation-Id`.

### Motivo

Sin contexto compartido, la trazabilidad entre servicios se rompe.

## ADR-003: Aplicar rate limiting distribuido con Redis

### Decision

Usar `RequestRateLimiter` de Spring Cloud Gateway respaldado por Redis.
La clave de rate limiting se resuelve por usuario autenticado, `X-Client-Id`, IP remota o `anonymous`.

### Motivo

El rate limiting debe funcionar aunque el gateway escale horizontalmente. Redis evita que cada instancia tenga contadores aislados.

### Consecuencias

- Requiere Redis local o gestionado.
- Permite responder 429 antes de cargar servicios internos.
- Falta agregar pruebas de integracion del filtro completo contra Redis.

## ADR-004: Parametrizar issuer OIDC

### Decision

Configurar `issuer-uri` por variable `APP_OIDC_ISSUER_URI`, con Keycloak local como valor por defecto.

### Motivo

Permite cambiar entre Keycloak local, mock OIDC o proveedor real sin tocar codigo.

### Consecuencias

- El gateway queda listo para validar JWT reales.
- El realm local de Keycloak queda versionado para demos reproducibles.
- Falta agregar tests WebFlux de 401/403/429 contra la configuracion completa.
