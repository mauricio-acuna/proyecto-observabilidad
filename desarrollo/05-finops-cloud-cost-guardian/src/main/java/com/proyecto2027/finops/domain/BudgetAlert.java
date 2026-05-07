package com.proyecto2027.finops.domain;

import java.math.BigDecimal;

public record BudgetAlert(
        String service,
        String environment,
        String severity,
        BigDecimal actualSpendUsd,
        BigDecimal budgetUsd,
        BigDecimal overBudgetUsd
) {
}
