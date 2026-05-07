package com.proyecto2027.finops.application;

import com.proyecto2027.finops.domain.BudgetAlert;
import com.proyecto2027.finops.domain.CloudCostRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EvaluateBudgetAlertsUseCase {

    private final CostProviderPort costProvider;
    private final BigDecimal defaultBudgetUsd;

    public EvaluateBudgetAlertsUseCase(
            CostProviderPort costProvider,
            @Value("${app.finops.budget.default-monthly-usd:1000}") BigDecimal defaultBudgetUsd
    ) {
        this.costProvider = costProvider;
        this.defaultBudgetUsd = defaultBudgetUsd;
    }

    public List<BudgetAlert> execute(LocalDate from, LocalDate to) {
        Map<BudgetKey, BigDecimal> totalByServiceAndEnvironment = costProvider.fetchCosts(from, to).stream()
                .collect(Collectors.groupingBy(
                        record -> new BudgetKey(record.service(), record.environment()),
                        Collectors.mapping(CloudCostRecord::amountUsd, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
                ));

        return totalByServiceAndEnvironment.entrySet().stream()
                .filter(entry -> entry.getValue().compareTo(defaultBudgetUsd) > 0)
                .map(entry -> new BudgetAlert(
                        entry.getKey().service(),
                        entry.getKey().environment(),
                        severity(entry.getValue()),
                        entry.getValue(),
                        defaultBudgetUsd,
                        entry.getValue().subtract(defaultBudgetUsd)
                ))
                .toList();
    }

    private String severity(BigDecimal actualSpendUsd) {
        BigDecimal criticalThreshold = defaultBudgetUsd.multiply(new BigDecimal("1.5"));
        if (actualSpendUsd.compareTo(criticalThreshold) >= 0) {
            return "HIGH";
        }
        return "MEDIUM";
    }

    private record BudgetKey(String service, String environment) {
    }
}
