package com.proyecto2027.gateway.filters;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CorrelationIdFilterTest {

    @Test
    void exposesStandardCorrelationHeaderName() {
        assertThat(CorrelationIdFilter.HEADER).isEqualTo("X-Correlation-Id");
    }
}
