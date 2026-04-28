package com.proyecto2027.template.infrastructure;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReadinessControllerTest {

    @Test
    void exposesTemplateReadinessMetadata() {
        var response = new ReadinessController().readiness();

        assertThat(response).containsEntry("status", "ready");
        assertThat(response).containsEntry("observability", "enabled");
    }
}
