package com.proyecto2027.risk.domain;

import java.util.List;
import java.util.UUID;

public record RiskDecision(
        UUID paymentId,
        RiskLevel riskLevel,
        List<String> reasons
) {
}
