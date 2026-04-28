package com.proyecto2027.aitriage.application;

import com.proyecto2027.aitriage.domain.TicketTriageRequest;
import com.proyecto2027.aitriage.domain.TriageResult;
import org.springframework.stereotype.Service;

@Service
public class TriageTicketUseCase {

    private static final String PROMPT_VERSION = "triage-v1";
    private final TriageModelPort modelPort;

    public TriageTicketUseCase(TriageModelPort modelPort) {
        this.modelPort = modelPort;
    }

    public TriageResult execute(TicketTriageRequest request) {
        return modelPort.classify(request, PROMPT_VERSION);
    }
}
