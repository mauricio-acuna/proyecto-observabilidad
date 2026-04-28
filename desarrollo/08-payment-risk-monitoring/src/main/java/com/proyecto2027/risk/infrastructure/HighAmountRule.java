package com.proyecto2027.risk.infrastructure;

import com.proyecto2027.risk.application.RiskRule;
import com.proyecto2027.risk.domain.Payment;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class HighAmountRule implements RiskRule {
    @Override
    public Optional<String> evaluate(Payment payment) {
        return payment.amount().compareTo(new BigDecimal("5000")) > 0
                ? Optional.of("High amount")
                : Optional.empty();
    }
}
