package com.proyecto2027.soportebancario.application;

import com.proyecto2027.soportebancario.domain.Customer;
import com.proyecto2027.soportebancario.domain.TicketCreatedEvent;
import com.proyecto2027.soportebancario.domain.TicketPriority;
import com.proyecto2027.soportebancario.infrastructure.persistence.InMemoryCustomerRepository;
import com.proyecto2027.soportebancario.infrastructure.persistence.InMemoryTicketRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OpenTicketUseCaseTest {

    @Test
    void opensTicketAndPublishesEvent() {
        CustomerRepository customers = new InMemoryCustomerRepository();
        TicketRepository tickets = new InMemoryTicketRepository();
        CapturingPublisher publisher = new CapturingPublisher();
        AuditPort audit = (action, aggregateId, detail) -> { };
        Customer customer = customers.save(Customer.register("123", "Mauricio Acuna", "mauricio@example.com"));

        OpenTicketUseCase useCase = new OpenTicketUseCase(customers, tickets, publisher, audit);

        var ticket = useCase.execute(customer.id(), "Card blocked", "Customer card was blocked", TicketPriority.HIGH);

        assertThat(ticket.id()).isNotNull();
        assertThat(ticket.priority()).isEqualTo(TicketPriority.HIGH);
        assertThat(publisher.events).hasSize(1);
        assertThat(publisher.events.get(0).ticketId()).isEqualTo(ticket.id());
    }

    private static class CapturingPublisher implements DomainEventPublisher {
        private final List<TicketCreatedEvent> events = new ArrayList<>();

        @Override
        public void publish(TicketCreatedEvent event) {
            events.add(event);
        }
    }
}
