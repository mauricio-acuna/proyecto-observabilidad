package com.proyecto2027.gateway.filters;

import org.slf4j.MDC;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class CorrelationIdFilter {

    public static final String HEADER = "X-Correlation-Id";

    @Bean
    GlobalFilter correlationGlobalFilter() {
        return (exchange, chain) -> {
            String correlationId = exchange.getRequest().getHeaders().getFirst(HEADER);
            if (correlationId == null || correlationId.isBlank()) {
                correlationId = UUID.randomUUID().toString();
            }
            String finalCorrelationId = correlationId;
            MDC.put("correlationId", finalCorrelationId);
            var mutatedRequest = exchange.getRequest().mutate().header(HEADER, finalCorrelationId).build();
            return chain.filter(exchange.mutate().request(mutatedRequest).build())
                    .doFinally(signal -> MDC.remove("correlationId"));
        };
    }
}
