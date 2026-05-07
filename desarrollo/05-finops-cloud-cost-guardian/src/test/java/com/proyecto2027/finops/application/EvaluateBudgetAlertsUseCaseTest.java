package com.proyecto2027.finops.application;

import com.proyecto2027.finops.domain.CloudCostRecord;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class EvaluateBudgetAlertsUseCaseTest {

    @Test
    void createsAlertsForServicesOverBudget() {
        CostProviderPort provider = (from, to) -> List.of(
                new CloudCostRecord(from, "banking-prod", "RDS", "prod", new BigDecimal("700")),
                new CloudCostRecord(from, "banking-prod", "RDS", "prod", new BigDecimal("500")),
                new CloudCostRecord(from, "banking-prod", "CloudWatch", "prod", new BigDecimal("100"))
        );

        var alerts = new EvaluateBudgetAlertsUseCase(provider, new BigDecimal("1000"))
                .execute(LocalDate.parse("2026-05-01"), LocalDate.parse("2026-05-31"));

        assertThat(alerts).hasSize(1);
        assertThat(alerts.get(0).service()).isEqualTo("RDS");
        assertThat(alerts.get(0).severity()).isEqualTo("MEDIUM");
        assertThat(alerts.get(0).overBudgetUsd()).isEqualByComparingTo("200");
    }

    @Test
    void marksLargeOverrunsAsHighSeverity() {
        CostProviderPort provider = (from, to) -> List.of(
                new CloudCostRecord(from, "banking-prod", "ECS", "prod", new BigDecimal("1600"))
        );

        var alerts = new EvaluateBudgetAlertsUseCase(provider, new BigDecimal("1000"))
                .execute(LocalDate.parse("2026-05-01"), LocalDate.parse("2026-05-31"));

        assertThat(alerts).extracting("severity").containsExactly("HIGH");
    }
}
