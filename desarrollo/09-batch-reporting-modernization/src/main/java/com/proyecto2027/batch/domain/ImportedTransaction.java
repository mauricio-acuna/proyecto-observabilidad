package com.proyecto2027.batch.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ImportedTransaction(
        String externalId,
        LocalDate date,
        BigDecimal amount,
        String currency,
        String customerReference
) {
    public boolean isValid() {
        return externalId != null
                && amount != null
                && amount.signum() >= 0
                && currency != null
                && currency.length() == 3;
    }
}
