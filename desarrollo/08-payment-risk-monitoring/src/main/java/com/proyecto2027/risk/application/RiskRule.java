package com.proyecto2027.risk.application;

import com.proyecto2027.risk.domain.Payment;

import java.util.Optional;

public interface RiskRule {
    Optional<String> evaluate(Payment payment);
}
