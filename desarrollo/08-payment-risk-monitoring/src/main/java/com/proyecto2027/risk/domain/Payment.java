package com.proyecto2027.risk.domain;

import java.math.BigDecimal;
import java.util.UUID;

public record Payment(
        UUID paymentId,
        UUID customerId,
        BigDecimal amount,
        String country,
        int attemptsLastHour
) {
}
