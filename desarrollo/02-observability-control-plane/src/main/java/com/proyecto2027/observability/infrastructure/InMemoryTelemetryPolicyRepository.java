package com.proyecto2027.observability.infrastructure;

import com.proyecto2027.observability.application.TelemetryPolicyRepository;
import com.proyecto2027.observability.domain.ServiceTelemetryPolicy;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryTelemetryPolicyRepository implements TelemetryPolicyRepository {

    private final List<ServiceTelemetryPolicy> policies = new ArrayList<>();

    @Override
    public ServiceTelemetryPolicy save(ServiceTelemetryPolicy policy) {
        policies.add(policy);
        return policy;
    }

    @Override
    public List<ServiceTelemetryPolicy> findAll() {
        return List.copyOf(policies);
    }
}
