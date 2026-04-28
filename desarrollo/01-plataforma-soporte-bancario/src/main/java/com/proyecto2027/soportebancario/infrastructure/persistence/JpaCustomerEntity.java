package com.proyecto2027.soportebancario.infrastructure.persistence;

import com.proyecto2027.soportebancario.domain.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "customers")
class JpaCustomerEntity {

    @Id
    private UUID id;

    @Column(nullable = false, unique = true)
    private String documentNumber;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Instant createdAt;

    protected JpaCustomerEntity() {
    }

    private JpaCustomerEntity(UUID id, String documentNumber, String fullName, String email, Instant createdAt) {
        this.id = id;
        this.documentNumber = documentNumber;
        this.fullName = fullName;
        this.email = email;
        this.createdAt = createdAt;
    }

    static JpaCustomerEntity fromDomain(Customer customer) {
        return new JpaCustomerEntity(
                customer.id(),
                customer.documentNumber(),
                customer.fullName(),
                customer.email(),
                customer.createdAt()
        );
    }

    Customer toDomain() {
        return new Customer(id, documentNumber, fullName, email, createdAt);
    }
}
