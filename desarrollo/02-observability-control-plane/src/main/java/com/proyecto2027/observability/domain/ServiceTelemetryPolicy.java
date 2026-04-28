package com.proyecto2027.observability.domain;

import java.util.Set;

public record ServiceTelemetryPolicy(
        String serviceName,
        Set<String> requiredLogFields,
        Set<String> requiredMetricTags,
        boolean tracingRequired,
        int maxAllowedMetricCardinality
) {
    public boolean isCompliant() {
        return requiredLogFields.contains("traceId")
                && requiredLogFields.contains("spanId")
                && requiredMetricTags.contains("service")
                && tracingRequired
                && maxAllowedMetricCardinality <= 100;
    }
}
