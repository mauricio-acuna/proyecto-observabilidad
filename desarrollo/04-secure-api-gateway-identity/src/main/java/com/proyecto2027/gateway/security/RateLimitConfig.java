package com.proyecto2027.gateway.security;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
public class RateLimitConfig {

    static final String CLIENT_ID_HEADER = "X-Client-Id";

    @Bean
    KeyResolver clientKeyResolver() {
        return exchange -> principalName(exchange)
                .switchIfEmpty(headerClientId(exchange))
                .switchIfEmpty(remoteAddress(exchange))
                .defaultIfEmpty("anonymous");
    }

    private Mono<String> principalName(ServerWebExchange exchange) {
        return exchange.getPrincipal().map(principal -> principal.getName());
    }

    private Mono<String> headerClientId(ServerWebExchange exchange) {
        return Mono.justOrEmpty(exchange.getRequest().getHeaders().getFirst(CLIENT_ID_HEADER))
                .filter(clientId -> !clientId.isBlank());
    }

    private Mono<String> remoteAddress(ServerWebExchange exchange) {
        return Mono.justOrEmpty(exchange.getRequest().getRemoteAddress())
                .map(address -> address.getAddress().getHostAddress());
    }
}
