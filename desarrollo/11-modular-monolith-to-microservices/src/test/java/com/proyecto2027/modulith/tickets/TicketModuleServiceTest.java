package com.proyecto2027.modulith.tickets;

import com.proyecto2027.modulith.customers.CustomerModuleApi;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TicketModuleServiceTest {

    @Test
    void opensTicketThroughCustomerModuleApiBoundary() {
        UUID customerId = UUID.randomUUID();
        CustomerModuleApi customers = id -> id.equals(customerId);
        var service = new TicketModuleService(customers);

        assertThat(service.openTicket(customerId, "Help")).isEqualTo("ticket-opened:Help");
        assertThatThrownBy(() -> service.openTicket(UUID.randomUUID(), "Help"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
