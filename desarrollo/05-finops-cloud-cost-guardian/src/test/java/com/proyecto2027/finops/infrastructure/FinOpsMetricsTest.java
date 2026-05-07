package com.proyecto2027.finops.infrastructure;

import com.proyecto2027.finops.domain.CloudCostRecord;
import com.proyecto2027.finops.domain.CostRecommendation;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FinOpsMetricsTest {

    @Test
    void recordsCostRecommendationAndSavingsMetrics() {
        var registry = new SimpleMeterRegistry();
        var metrics = new FinOpsMetrics(registry);

        metrics.recordAnalysis(
                List.of(new CloudCostRecord(
                        LocalDate.parse("2026-05-01"),
                        "banking-prod",
                        "RDS",
                        "prod",
                        new BigDecimal("800")
                )),
                List.of(new CostRecommendation(
                        "RDS",
                        "MEDIUM",
                        "Review right sizing",
                        new BigDecimal("120")
                ))
        );

        assertThat(registry.get("finops_cost_records_analyzed_total").counter().count()).isEqualTo(1.0);
        assertThat(registry.get("finops_recommendations_total").counter().count()).isEqualTo(1.0);
        assertThat(registry.get("finops_cost_analyzed_usd_total")
                .tag("service", "RDS")
                .tag("environment", "prod")
                .counter()
                .count()).isEqualTo(800.0);
        assertThat(registry.get("finops_estimated_savings_usd_total")
                .tag("service", "RDS")
                .counter()
                .count()).isEqualTo(120.0);
    }
}
