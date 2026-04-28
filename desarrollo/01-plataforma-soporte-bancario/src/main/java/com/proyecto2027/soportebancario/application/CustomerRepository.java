package com.proyecto2027.soportebancario.application;

import com.proyecto2027.soportebancario.domain.Customer;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {
    Customer save(Customer customer);

    Optional<Customer> findById(UUID id);
}
