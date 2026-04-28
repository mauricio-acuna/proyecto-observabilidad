package com.proyecto2027.soportebancario.infrastructure.persistence;

import com.proyecto2027.soportebancario.application.TicketRepository;
import com.proyecto2027.soportebancario.domain.SupportTicket;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Profile("!in-memory")
public class JpaTicketRepositoryAdapter implements TicketRepository {

    private final SpringDataTicketJpaRepository repository;

    public JpaTicketRepositoryAdapter(SpringDataTicketJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public SupportTicket save(SupportTicket ticket) {
        return repository.save(JpaSupportTicketEntity.fromDomain(ticket)).toDomain();
    }

    @Override
    public Optional<SupportTicket> findById(UUID id) {
        return repository.findById(id).map(JpaSupportTicketEntity::toDomain);
    }

    @Override
    public List<SupportTicket> findByCustomerId(UUID customerId) {
        return repository.findByCustomerId(customerId).stream()
                .map(JpaSupportTicketEntity::toDomain)
                .toList();
    }
}
