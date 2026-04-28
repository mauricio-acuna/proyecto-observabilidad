package com.proyecto2027.observability.infrastructure;

import com.proyecto2027.observability.application.RegisterTelemetryPolicyUseCase;
import com.proyecto2027.observability.application.TelemetryPolicyRepository;
import com.proyecto2027.observability.domain.ServiceTelemetryPolicy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/telemetry-policies")
public class TelemetryPolicyController {

    private final RegisterTelemetryPolicyUseCase registerUseCase;
    private final TelemetryPolicyRepository repository;

    public TelemetryPolicyController(RegisterTelemetryPolicyUseCase registerUseCase, TelemetryPolicyRepository repository) {
        this.registerUseCase = registerUseCase;
        this.repository = repository;
    }

    @PostMapping
    public ServiceTelemetryPolicy register(@RequestBody ServiceTelemetryPolicy policy) {
        return registerUseCase.execute(policy);
    }

    @GetMapping
    public List<ServiceTelemetryPolicy> list() {
        return repository.findAll();
    }
}
