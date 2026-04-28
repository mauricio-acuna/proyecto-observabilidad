package com.proyecto2027.soportebancario.infrastructure.persistence;

import com.proyecto2027.soportebancario.application.TicketRepository;
import com.proyecto2027.soportebancario.domain.SupportTicket;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryTicketRepository implements TicketRepository {

    private final Map<UUID, SupportTicket> tickets = new ConcurrentHashMap<>();

    @Override
    public SupportTicket save(SupportTicket ticket) {
        tickets.put(ticket.id(), ticket);
        return ticket;
    }

    @Override
    public Optional<SupportTicket> findById(UUID id) {
        return Optional.ofNullable(tickets.get(id));
    }

    @Override
    public List<SupportTicket> findByCustomerId(UUID customerId) {
        return tickets.values().stream()
                .filter(ticket -> ticket.customerId().equals(customerId))
                .toList();
    }
}
