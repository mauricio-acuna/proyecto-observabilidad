package com.proyecto2027.finops.infrastructure;

import com.proyecto2027.finops.application.CostAnalysisObserver;
import com.proyecto2027.finops.domain.CloudCostRecord;
import com.proyecto2027.finops.domain.CostRecommendation;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class FinOpsMetrics implements CostAnalysisObserver {

    private final MeterRegistry registry;

    public FinOpsMetrics(MeterRegistry registry) {
        this.registry = registry;
    }

    @Override
    public void recordAnalysis(List<CloudCostRecord> records, List<CostRecommendation> recommendations) {
        counter("finops_cost_records_analyzed_total").increment(records.size());
        counter("finops_recommendations_total").increment(recommendations.size());
        recommendations.forEach(recommendation -> {
            counter(
                    "finops_recommendations_by_severity_total",
                    "severity", recommendation.severity()
            ).increment();
            counter(
                    "finops_estimated_savings_usd_total",
                    "service", recommendation.service()
            ).increment(toDouble(recommendation.estimatedMonthlySavingUsd()));
        });
        records.forEach(record -> counter(
                "finops_cost_analyzed_usd_total",
                "service", record.service(),
                "environment", record.environment()
        ).increment(toDouble(record.amountUsd())));
    }

    private Counter counter(String metricName, String... tags) {
        return Counter.builder(metricName)
                .tags(tags)
                .register(registry);
    }

    private static double toDouble(BigDecimal value) {
        return value == null ? 0 : value.doubleValue();
    }
}
