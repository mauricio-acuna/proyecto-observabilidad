package com.proyecto2027.soportebancario.application;

import com.proyecto2027.soportebancario.domain.SupportTicket;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TicketRepository {
    SupportTicket save(SupportTicket ticket);

    Optional<SupportTicket> findById(UUID id);

    List<SupportTicket> findByCustomerId(UUID customerId);
}
