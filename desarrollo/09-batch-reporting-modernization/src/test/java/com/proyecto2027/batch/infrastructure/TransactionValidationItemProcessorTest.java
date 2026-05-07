package com.proyecto2027.batch.infrastructure;

import com.proyecto2027.batch.application.TransactionImportPort;
import com.proyecto2027.batch.domain.ImportedTransaction;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

class TransactionValidationItemProcessorTest {

    @Test
    void filtersRejectedTransactionsAndStoresReason() throws Exception {
        AtomicInteger rejected = new AtomicInteger();
        TransactionImportPort port = new TransactionImportPort() {
            @Override
            public void storeValid(ImportedTransaction transaction) {
            }

            @Override
            public void storeRejected(ImportedTransaction transaction, String reason) {
                rejected.incrementAndGet();
            }
        };
        var registry = new SimpleMeterRegistry();
        var processor = new TransactionValidationItemProcessor(port, new BatchImportMetrics(registry));

        ImportedTransaction valid = new ImportedTransaction("tx-1", LocalDate.now(), BigDecimal.TEN, "EUR", "cust");
        ImportedTransaction invalid = new ImportedTransaction("tx-2", LocalDate.now(), BigDecimal.TEN.negate(), "EUR", "cust");

        assertThat(processor.process(valid)).isEqualTo(valid);
        assertThat(processor.process(invalid)).isNull();
        assertThat(rejected).hasValue(1);
        assertThat(registry.get("batch_transactions_total")
                .tag("result", "rejected")
                .counter()
                .count()).isEqualTo(1.0);
    }
}
