package com.proyecto2027.finops.application;

import com.proyecto2027.finops.domain.CloudCostRecord;
import com.proyecto2027.finops.domain.CostRecommendation;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AnalyzeCostUseCase {

    private final CostProviderPort costProvider;

    public AnalyzeCostUseCase(CostProviderPort costProvider) {
        this.costProvider = costProvider;
    }

    public List<CostRecommendation> execute(LocalDate from, LocalDate to) {
        List<CloudCostRecord> records = costProvider.fetchCosts(from, to);
        Map<String, BigDecimal> totalByService = records.stream()
                .collect(Collectors.groupingBy(
                        CloudCostRecord::service,
                        Collectors.mapping(CloudCostRecord::amountUsd, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
                ));

        return totalByService.entrySet().stream()
                .filter(entry -> entry.getValue().compareTo(new BigDecimal("500")) > 0)
                .map(entry -> new CostRecommendation(
                        entry.getKey(),
                        "MEDIUM",
                        "Review right sizing, schedules and unused resources for " + entry.getKey(),
                        entry.getValue().multiply(new BigDecimal("0.15"))
                ))
                .toList();
    }
}
