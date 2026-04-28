package com.proyecto2027.risk.application;

import com.proyecto2027.risk.domain.Payment;
import com.proyecto2027.risk.domain.RiskLevel;
import com.proyecto2027.risk.infrastructure.HighAmountRule;
import com.proyecto2027.risk.infrastructure.RepeatedAttemptsRule;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class EvaluatePaymentRiskUseCaseTest {

    @Test
    void marksPaymentAsHighRiskWhenMultipleRulesMatch() {
        var useCase = new EvaluatePaymentRiskUseCase(List.of(new HighAmountRule(), new RepeatedAttemptsRule()));
        var payment = new Payment(UUID.randomUUID(), UUID.randomUUID(), new BigDecimal("9000"), "ES", 7);

        var decision = useCase.execute(payment);

        assertThat(decision.riskLevel()).isEqualTo(RiskLevel.HIGH);
        assertThat(decision.reasons()).contains("High amount", "Repeated attempts");
    }
}
