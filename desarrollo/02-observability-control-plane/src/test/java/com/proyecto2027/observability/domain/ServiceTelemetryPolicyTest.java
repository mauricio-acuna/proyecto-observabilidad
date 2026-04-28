package com.proyecto2027.observability.domain;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class ServiceTelemetryPolicyTest {

    @Test
    void compliantPolicyRequiresCorrelationTracingAndControlledCardinality() {
        var policy = new ServiceTelemetryPolicy(
                "ticket-service",
                Set.of("traceId", "spanId", "level", "message"),
                Set.of("service", "environment"),
                true,
                50
        );

        assertThat(policy.isCompliant()).isTrue();
    }

    @Test
    void highCardinalityPolicyIsNotCompliant() {
        var policy = new ServiceTelemetryPolicy(
                "ticket-service",
                Set.of("traceId", "spanId"),
                Set.of("service"),
                true,
                1_000
        );

        assertThat(policy.isCompliant()).isFalse();
    }
}
