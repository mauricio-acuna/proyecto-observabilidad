package com.proyecto2027.modulith.tickets;

import com.proyecto2027.modulith.customers.CustomerModuleApi;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TicketModuleService {

    private final CustomerModuleApi customerModuleApi;

    public TicketModuleService(CustomerModuleApi customerModuleApi) {
        this.customerModuleApi = customerModuleApi;
    }

    public String openTicket(UUID customerId, String subject) {
        if (!customerModuleApi.customerExists(customerId)) {
            throw new IllegalArgumentException("Customer does not exist");
        }
        return "ticket-opened:" + subject;
    }
}
