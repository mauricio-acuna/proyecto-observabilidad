package com.proyecto2027.incidents.infrastructure;

import com.proyecto2027.incidents.application.IncidentRepository;
import com.proyecto2027.incidents.domain.Incident;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryIncidentRepository implements IncidentRepository {

    private final List<Incident> incidents = new ArrayList<>();

    @Override
    public Incident save(Incident incident) {
        incidents.add(incident);
        return incident;
    }

    @Override
    public List<Incident> findAll() {
        return List.copyOf(incidents);
    }
}
