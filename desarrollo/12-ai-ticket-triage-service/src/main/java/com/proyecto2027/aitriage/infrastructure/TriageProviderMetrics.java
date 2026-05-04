package com.proyecto2027.aitriage.infrastructure;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class TriageProviderMetrics {

    private static final String INPUT_TOKENS_HEADER = "X-Input-Tokens";
    private static final String OUTPUT_TOKENS_HEADER = "X-Output-Tokens";
    private static final String ESTIMATED_COST_HEADER = "X-Estimated-Cost-Usd";

    private final MeterRegistry registry;

    public TriageProviderMetrics(MeterRegistry registry) {
        this.registry = registry;
    }

    void providerSuccess(String provider, HttpHeaders headers) {
        counter("ai_triage_provider_requests_total", "provider", provider, "result", "success").increment();
        incrementIfPresent("ai_triage_tokens_total", headers, INPUT_TOKENS_HEADER, "type", "input");
        incrementIfPresent("ai_triage_tokens_total", headers, OUTPUT_TOKENS_HEADER, "type", "output");
        incrementIfPresent("ai_triage_estimated_cost_usd_total", headers, ESTIMATED_COST_HEADER);
    }

    void providerFallback(String provider, String reason) {
        counter("ai_triage_provider_requests_total", "provider", provider, "result", "fallback").increment();
        counter("ai_triage_fallback_total", "provider", provider, "reason", reason).increment();
    }

    private void incrementIfPresent(String metricName, HttpHeaders headers, String headerName, String... tags) {
        double value = parseDouble(headers.getFirst(headerName));
        if (value > 0) {
            counter(metricName, tags).increment(value);
        }
    }

    private Counter counter(String metricName, String... tags) {
        return Counter.builder(metricName)
                .tags(tags)
                .register(registry);
    }

    private static double parseDouble(String value) {
        if (value == null || value.isBlank()) {
            return 0;
        }
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException ex) {
            return 0;
        }
    }
}
