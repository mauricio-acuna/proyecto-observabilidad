package com.proyecto2027.modulith.tickets;

import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/modulith/tickets")
public class TicketModuleController {

    private final TicketModuleService ticketModuleService;

    public TicketModuleController(TicketModuleService ticketModuleService) {
        this.ticketModuleService = ticketModuleService;
    }

    @PostMapping
    public String open(@RequestBody OpenTicketCommand command) {
        return ticketModuleService.openTicket(command.customerId(), command.subject());
    }

    public record OpenTicketCommand(UUID customerId, String subject) {
    }
}
