package com.proyecto2027.finops.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CloudCostRecord(
        LocalDate date,
        String account,
        String service,
        String environment,
        BigDecimal amountUsd
) {
}
