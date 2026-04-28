package com.proyecto2027.aitriage.infrastructure;

import com.proyecto2027.aitriage.application.TriageModelPort;
import com.proyecto2027.aitriage.domain.TicketTriageRequest;
import com.proyecto2027.aitriage.domain.TriageResult;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RuleBasedTriageModelAdapter implements TriageModelPort {
    @Override
    public TriageResult classify(TicketTriageRequest request, String promptVersion) {
        boolean cardIssue = request.description().toLowerCase().contains("card");
        return new TriageResult(
                cardIssue ? "CARDS" : "GENERAL_SUPPORT",
                cardIssue ? "HIGH" : "MEDIUM",
                cardIssue ? List.of("card") : List.of(),
                request.subject(),
                cardIssue ? "Verify identity and review card status" : "Route to support queue",
                promptVersion
        );
    }
}
