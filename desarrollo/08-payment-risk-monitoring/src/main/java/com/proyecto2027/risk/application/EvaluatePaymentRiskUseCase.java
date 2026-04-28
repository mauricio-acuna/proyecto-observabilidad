package com.proyecto2027.risk.application;

import com.proyecto2027.risk.domain.Payment;
import com.proyecto2027.risk.domain.RiskDecision;
import com.proyecto2027.risk.domain.RiskLevel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluatePaymentRiskUseCase {

    private final List<RiskRule> rules;

    public EvaluatePaymentRiskUseCase(List<RiskRule> rules) {
        this.rules = rules;
    }

    public RiskDecision execute(Payment payment) {
        List<String> reasons = rules.stream()
                .map(rule -> rule.evaluate(payment))
                .flatMap(Optional::stream)
                .toList();

        RiskLevel level = reasons.size() >= 2 ? RiskLevel.HIGH : reasons.isEmpty() ? RiskLevel.LOW : RiskLevel.MEDIUM;
        return new RiskDecision(payment.paymentId(), level, reasons);
    }
}
