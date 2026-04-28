package com.proyecto2027.soportebancario.infrastructure.persistence;

import com.proyecto2027.soportebancario.application.CustomerRepository;
import com.proyecto2027.soportebancario.domain.Customer;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@Profile("!in-memory")
public class JpaCustomerRepositoryAdapter implements CustomerRepository {

    private final SpringDataCustomerJpaRepository repository;

    public JpaCustomerRepositoryAdapter(SpringDataCustomerJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer save(Customer customer) {
        return repository.save(JpaCustomerEntity.fromDomain(customer)).toDomain();
    }

    @Override
    public Optional<Customer> findById(UUID id) {
        return repository.findById(id).map(JpaCustomerEntity::toDomain);
    }
}
