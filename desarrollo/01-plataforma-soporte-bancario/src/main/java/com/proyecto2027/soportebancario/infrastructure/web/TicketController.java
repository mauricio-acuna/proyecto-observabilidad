package com.proyecto2027.soportebancario.infrastructure.web;

import com.proyecto2027.soportebancario.application.OpenTicketUseCase;
import com.proyecto2027.soportebancario.domain.SupportTicket;
import com.proyecto2027.soportebancario.domain.TicketPriority;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final OpenTicketUseCase openTicketUseCase;

    public TicketController(OpenTicketUseCase openTicketUseCase) {
        this.openTicketUseCase = openTicketUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SupportTicket open(@Valid @RequestBody OpenTicketRequest request) {
        return openTicketUseCase.execute(
                request.customerId(),
                request.subject(),
                request.description(),
                request.priority()
        );
    }

    public record OpenTicketRequest(
            @NotNull UUID customerId,
            @NotBlank String subject,
            @NotBlank String description,
            @NotNull TicketPriority priority
    ) {
    }
}
