package com.proyecto2027.finops.domain;

import java.math.BigDecimal;

public record CostRecommendation(
        String service,
        String severity,
        String recommendation,
        BigDecimal estimatedMonthlySavingUsd
) {
}
