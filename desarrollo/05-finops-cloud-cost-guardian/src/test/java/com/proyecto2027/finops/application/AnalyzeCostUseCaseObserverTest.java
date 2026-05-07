package com.proyecto2027.finops.application;

import com.proyecto2027.finops.domain.CloudCostRecord;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

class AnalyzeCostUseCaseObserverTest {

    @Test
    void notifiesObserversAfterAnalysis() {
        AtomicInteger observedRecommendations = new AtomicInteger();
        CostAnalysisObserver observer = (records, recommendations) ->
                observedRecommendations.set(recommendations.size());
        var useCase = new AnalyzeCostUseCase(
                (from, to) -> List.of(new CloudCostRecord(
                        from,
                        "banking-prod",
                        "ECS",
                        "prod",
                        new BigDecimal("600")
                )),
                List.of(observer)
        );

        useCase.execute(LocalDate.parse("2026-05-01"), LocalDate.parse("2026-05-06"));

        assertThat(observedRecommendations).hasValue(1);
    }
}
