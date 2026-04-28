package com.proyecto2027.aitriage.infrastructure;

import com.proyecto2027.aitriage.application.TriageTicketUseCase;
import com.proyecto2027.aitriage.domain.TicketTriageRequest;
import com.proyecto2027.aitriage.domain.TriageResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/triage")
public class TriageController {

    private final TriageTicketUseCase useCase;

    public TriageController(TriageTicketUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public TriageResult triage(@RequestBody TicketTriageRequest request) {
        return useCase.execute(request);
    }
}
