package com.proyecto2027.incidents.application;

import com.proyecto2027.incidents.domain.Severity;
import com.proyecto2027.incidents.infrastructure.InMemoryIncidentRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OpenIncidentUseCaseTest {

    @Test
    void opensIncidentWithSeverityAndService() {
        var repository = new InMemoryIncidentRepository();
        var incident = new OpenIncidentUseCase(repository)
                .execute("ticket-service", Severity.SEV2, "Latency above SLO");

        assertThat(incident.id()).isNotNull();
        assertThat(incident.serviceName()).isEqualTo("ticket-service");
        assertThat(repository.findAll()).hasSize(1);
    }
}
