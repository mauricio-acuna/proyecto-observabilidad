package com.proyecto2027.risk.infrastructure;

import com.proyecto2027.risk.application.EvaluatePaymentRiskUseCase;
import com.proyecto2027.risk.domain.Payment;
import com.proyecto2027.risk.domain.RiskDecision;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments/risk")
public class PaymentRiskController {

    private final EvaluatePaymentRiskUseCase useCase;

    public PaymentRiskController(EvaluatePaymentRiskUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public RiskDecision evaluate(@RequestBody Payment payment) {
        return useCase.execute(payment);
    }
}
