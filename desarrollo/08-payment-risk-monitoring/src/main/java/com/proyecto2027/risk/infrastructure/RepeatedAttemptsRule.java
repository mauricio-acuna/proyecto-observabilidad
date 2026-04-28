package com.proyecto2027.risk.infrastructure;

import com.proyecto2027.risk.application.RiskRule;
import com.proyecto2027.risk.domain.Payment;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RepeatedAttemptsRule implements RiskRule {
    @Override
    public Optional<String> evaluate(Payment payment) {
        return payment.attemptsLastHour() >= 5
                ? Optional.of("Repeated attempts")
                : Optional.empty();
    }
}
