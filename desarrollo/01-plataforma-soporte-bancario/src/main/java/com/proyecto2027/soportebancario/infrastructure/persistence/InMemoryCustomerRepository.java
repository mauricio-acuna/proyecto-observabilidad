package com.proyecto2027.soportebancario.infrastructure.persistence;

import com.proyecto2027.soportebancario.application.CustomerRepository;
import com.proyecto2027.soportebancario.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

    private final Map<UUID, Customer> customers = new ConcurrentHashMap<>();

    @Override
    public Customer save(Customer customer) {
        customers.put(customer.id(), customer);
        return customer;
    }

    @Override
    public Optional<Customer> findById(UUID id) {
        return Optional.ofNullable(customers.get(id));
    }
}
