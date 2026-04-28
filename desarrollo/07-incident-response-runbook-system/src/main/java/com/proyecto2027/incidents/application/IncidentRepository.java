package com.proyecto2027.incidents.application;

import com.proyecto2027.incidents.domain.Incident;

import java.util.List;

public interface IncidentRepository {
    Incident save(Incident incident);

    List<Incident> findAll();
}
