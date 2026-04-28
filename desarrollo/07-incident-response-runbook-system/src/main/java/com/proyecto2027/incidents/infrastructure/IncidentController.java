package com.proyecto2027.incidents.infrastructure;

import com.proyecto2027.incidents.application.IncidentRepository;
import com.proyecto2027.incidents.application.OpenIncidentUseCase;
import com.proyecto2027.incidents.domain.Incident;
import com.proyecto2027.incidents.domain.Severity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incidents")
public class IncidentController {

    private final OpenIncidentUseCase openIncidentUseCase;
    private final IncidentRepository repository;

    public IncidentController(OpenIncidentUseCase openIncidentUseCase, IncidentRepository repository) {
        this.openIncidentUseCase = openIncidentUseCase;
        this.repository = repository;
    }

    @PostMapping
    public Incident open(@RequestBody OpenIncidentRequest request) {
        return openIncidentUseCase.execute(request.serviceName(), request.severity(), request.summary());
    }

    @GetMapping
    public List<Incident> list() {
        return repository.findAll();
    }

    public record OpenIncidentRequest(String serviceName, Severity severity, String summary) {
    }
}
