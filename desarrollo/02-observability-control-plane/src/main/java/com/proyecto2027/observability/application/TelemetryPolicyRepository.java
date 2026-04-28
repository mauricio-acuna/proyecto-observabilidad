package com.proyecto2027.observability.application;

import com.proyecto2027.observability.domain.ServiceTelemetryPolicy;

import java.util.List;

public interface TelemetryPolicyRepository {
    ServiceTelemetryPolicy save(ServiceTelemetryPolicy policy);

    List<ServiceTelemetryPolicy> findAll();
}
