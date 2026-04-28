package com.proyecto2027.soportebancario.application;

import com.proyecto2027.soportebancario.domain.Customer;
import org.springframework.stereotype.Service;

@Service
public class RegisterCustomerUseCase {

    private final CustomerRepository customerRepository;
    private final AuditPort auditPort;

    public RegisterCustomerUseCase(CustomerRepository customerRepository, AuditPort auditPort) {
        this.customerRepository = customerRepository;
        this.auditPort = auditPort;
    }

    public Customer execute(String documentNumber, String fullName, String email) {
        Customer customer = Customer.register(documentNumber, fullName, email);
        Customer saved = customerRepository.save(customer);
        auditPort.record("CUSTOMER_REGISTERED", saved.id(), "Customer registered from support platform");
        return saved;
    }
}
