package com.proyecto2027.observability.application;

import com.proyecto2027.observability.domain.ServiceTelemetryPolicy;
import org.springframework.stereotype.Service;

@Service
public class RegisterTelemetryPolicyUseCase {

    private final TelemetryPolicyRepository repository;

    public RegisterTelemetryPolicyUseCase(TelemetryPolicyRepository repository) {
        this.repository = repository;
    }

    public ServiceTelemetryPolicy execute(ServiceTelemetryPolicy policy) {
        return repository.save(policy);
    }
}
