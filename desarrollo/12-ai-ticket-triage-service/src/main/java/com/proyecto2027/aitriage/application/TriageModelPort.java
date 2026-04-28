package com.proyecto2027.aitriage.application;

import com.proyecto2027.aitriage.domain.TicketTriageRequest;
import com.proyecto2027.aitriage.domain.TriageResult;

public interface TriageModelPort {
    TriageResult classify(TicketTriageRequest request, String promptVersion);
}
