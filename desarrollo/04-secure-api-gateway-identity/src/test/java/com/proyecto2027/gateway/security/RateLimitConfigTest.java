package com.proyecto2027.gateway.security;

import org.junit.jupiter.api.Test;
import org.springframework.mock.http.server.reactive.MockServerHttpRequest;
import org.springframework.mock.web.server.MockServerWebExchange;

import static org.assertj.core.api.Assertions.assertThat;

class RateLimitConfigTest {

    private final RateLimitConfig config = new RateLimitConfig();

    @Test
    void resolvesClientIdHeaderWhenPrincipalIsMissing() {
        var exchange = MockServerWebExchange.from(
                MockServerHttpRequest.get("/support/tickets")
                        .header(RateLimitConfig.CLIENT_ID_HEADER, "mobile-app")
        );

        String key = config.clientKeyResolver().resolve(exchange).block();

        assertThat(key).isEqualTo("mobile-app");
    }

    @Test
    void fallsBackToAnonymousWhenNoClientSignalExists() {
        var exchange = MockServerWebExchange.from(MockServerHttpRequest.get("/support/tickets"));

        String key = config.clientKeyResolver().resolve(exchange).block();

        assertThat(key).isEqualTo("anonymous");
    }
}
