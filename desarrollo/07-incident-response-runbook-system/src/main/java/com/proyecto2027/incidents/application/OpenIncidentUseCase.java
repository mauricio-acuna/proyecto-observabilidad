package com.proyecto2027.incidents.application;

import com.proyecto2027.incidents.domain.Incident;
import com.proyecto2027.incidents.domain.Severity;
import org.springframework.stereotype.Service;

@Service
public class OpenIncidentUseCase {

    private final IncidentRepository repository;

    public OpenIncidentUseCase(IncidentRepository repository) {
        this.repository = repository;
    }

    public Incident execute(String serviceName, Severity severity, String summary) {
        return repository.save(Incident.open(serviceName, severity, summary));
    }
}
