package com.proyecto2027.soportebancario.infrastructure.persistence;

import com.proyecto2027.soportebancario.application.CustomerRepository;
import com.proyecto2027.soportebancario.application.TicketRepository;
import com.proyecto2027.soportebancario.domain.Customer;
import com.proyecto2027.soportebancario.domain.SupportTicket;
import com.proyecto2027.soportebancario.domain.TicketPriority;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import({JpaCustomerRepositoryAdapter.class, JpaTicketRepositoryAdapter.class})
@Testcontainers(disabledWithoutDocker = true)
class JpaSupportPlatformRepositoryTest {

    @Container
    static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine")
            .withDatabaseName("proyecto2027")
            .withUsername("proyecto2027")
            .withPassword("proyecto2027");

    @DynamicPropertySource
    static void datasourceProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    private final CustomerRepository customerRepository;
    private final TicketRepository ticketRepository;

    @Autowired
    JpaSupportPlatformRepositoryTest(CustomerRepository customerRepository, TicketRepository ticketRepository) {
        this.customerRepository = customerRepository;
        this.ticketRepository = ticketRepository;
    }

    @Test
    void persistsCustomerAndTicketWithPostgres() {
        Customer customer = customerRepository.save(
                Customer.register("12345678", "Mauricio Acuna", "mauricio@example.com")
        );
        SupportTicket ticket = ticketRepository.save(
                SupportTicket.open(customer.id(), "Card blocked", "Customer card was blocked", TicketPriority.HIGH)
        );

        assertThat(customerRepository.findById(customer.id())).contains(customer);
        assertThat(ticketRepository.findById(ticket.id())).contains(ticket);
        assertThat(ticketRepository.findByCustomerId(customer.id())).containsExactly(ticket);
    }
}
