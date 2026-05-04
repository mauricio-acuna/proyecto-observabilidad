package com.proyecto2027.aitriage.infrastructure;

import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;

import static org.assertj.core.api.Assertions.assertThat;

class TriageProviderMetricsTest {

    @Test
    void recordsProviderTokensCostAndFallbacks() {
        var registry = new SimpleMeterRegistry();
        var metrics = new TriageProviderMetrics(registry);
        var headers = new HttpHeaders();
        headers.add("X-Input-Tokens", "120");
        headers.add("X-Output-Tokens", "45");
        headers.add("X-Estimated-Cost-Usd", "0.0035");

        metrics.providerSuccess("external", headers);
        metrics.providerFallback("external", "provider_error");

        assertThat(registry.get("ai_triage_provider_requests_total")
                .tag("provider", "external")
                .tag("result", "success")
                .counter()
                .count()).isEqualTo(1.0);
        assertThat(registry.get("ai_triage_tokens_total")
                .tag("type", "input")
                .counter()
                .count()).isEqualTo(120.0);
        assertThat(registry.get("ai_triage_tokens_total")
                .tag("type", "output")
                .counter()
                .count()).isEqualTo(45.0);
        assertThat(registry.get("ai_triage_estimated_cost_usd_total")
                .counter()
                .count()).isEqualTo(0.0035);
        assertThat(registry.get("ai_triage_fallback_total")
                .tag("reason", "provider_error")
                .counter()
                .count()).isEqualTo(1.0);
    }
}
