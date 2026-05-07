package com.proyecto2027.batch.infrastructure;

import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BatchImportMetricsTest {

    @Test
    void recordsValidAndRejectedTransactions() {
        var registry = new SimpleMeterRegistry();
        var metrics = new BatchImportMetrics(registry);

        metrics.recordValid();
        metrics.recordRejected();

        assertThat(registry.get("batch_transactions_total")
                .tag("result", "valid")
                .counter()
                .count()).isEqualTo(1.0);
        assertThat(registry.get("batch_transactions_total")
                .tag("result", "rejected")
                .counter()
                .count()).isEqualTo(1.0);
    }
}
