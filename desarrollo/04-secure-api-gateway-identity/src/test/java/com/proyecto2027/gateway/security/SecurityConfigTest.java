package com.proyecto2027.gateway.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.gateway.filter.ratelimit.RateLimiter.Response;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.mockJwt;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {
                "spring.cloud.gateway.routes[0].id=support-platform",
                "spring.cloud.gateway.routes[0].uri=http://localhost:8081",
                "spring.cloud.gateway.routes[0].predicates[0]=Path=/support/**",
                "spring.cloud.gateway.routes[0].filters[0]=StripPrefix=1",
                "spring.cloud.gateway.routes[0].filters[1].name=RequestRateLimiter",
                "spring.cloud.gateway.routes[0].filters[1].args.redis-rate-limiter.replenishRate=10",
                "spring.cloud.gateway.routes[0].filters[1].args.redis-rate-limiter.burstCapacity=20",
                "spring.cloud.gateway.routes[0].filters[1].args.key-resolver=#{@clientKeyResolver}"
        }
)
@AutoConfigureWebTestClient
class SecurityConfigTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private RedisRateLimiter redisRateLimiter;

    @Test
    void rejectsUnauthenticatedSupportRequestsWith401() {
        webTestClient.get()
                .uri("/support/api/tickets")
                .exchange()
                .expectStatus().isUnauthorized();
    }

    @Test
    void rejectsAuthenticatedUserWithoutSupportRoleWith403() {
        webTestClient.mutateWith(mockJwt().jwt(jwt -> jwt.claim("realm_access", Map.of("roles", List.of("other_role")))))
                .get()
                .uri("/support/api/tickets")
                .exchange()
                .expectStatus().isForbidden();
    }

    @Test
    void rejectsSupportRequestsOverRateLimitWith429() {
        when(redisRateLimiter.isAllowed(eq("support-platform"), anyString()))
                .thenReturn(Mono.just(new Response(false, Map.of("X-RateLimit-Remaining", "0"))));

        webTestClient.mutateWith(mockJwt()
                        .authorities(new SimpleGrantedAuthority("ROLE_support_user"))
                        .jwt(jwt -> jwt.claim("realm_access", Map.of("roles", List.of("support_user")))))
                .get()
                .uri("/support/api/tickets")
                .header(RateLimitConfig.CLIENT_ID_HEADER, "mobile-app")
                .exchange()
                .expectStatus().isEqualTo(429);
    }
}
