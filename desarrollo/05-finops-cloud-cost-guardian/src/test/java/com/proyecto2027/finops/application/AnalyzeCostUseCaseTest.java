package com.proyecto2027.finops.application;

import com.proyecto2027.finops.domain.CloudCostRecord;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AnalyzeCostUseCaseTest {

    @Test
    void createsRecommendationsForExpensiveServices() {
        CostProviderPort provider = (from, to) -> List.of(
                new CloudCostRecord(from, "acc", "ECS", "prod", new BigDecimal("600")),
                new CloudCostRecord(from, "acc", "CloudWatch", "prod", new BigDecimal("100"))
        );

        var recommendations = new AnalyzeCostUseCase(provider, List.of())
                .execute(LocalDate.now().minusDays(7), LocalDate.now());

        assertThat(recommendations)
                .extracting("service")
                .containsExactly("ECS");
    }
}
