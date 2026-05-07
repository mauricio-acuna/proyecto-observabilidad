package com.proyecto2027.batch.infrastructure;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class BatchImportMetrics {

    private final MeterRegistry registry;

    public BatchImportMetrics(MeterRegistry registry) {
        this.registry = registry;
    }

    void recordValid() {
        counter("batch_transactions_total", "result", "valid").increment();
    }

    void recordRejected() {
        counter("batch_transactions_total", "result", "rejected").increment();
    }

    private Counter counter(String metricName, String... tags) {
        return Counter.builder(metricName)
                .tags(tags)
                .register(registry);
    }
}
