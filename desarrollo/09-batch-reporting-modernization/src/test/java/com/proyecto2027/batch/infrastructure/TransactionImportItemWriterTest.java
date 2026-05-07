package com.proyecto2027.batch.infrastructure;

import com.proyecto2027.batch.application.TransactionImportPort;
import com.proyecto2027.batch.domain.ImportedTransaction;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.junit.jupiter.api.Test;
import org.springframework.batch.item.Chunk;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

class TransactionImportItemWriterTest {

    @Test
    void writesValidTransactionsThroughImportPort() throws Exception {
        AtomicInteger valid = new AtomicInteger();
        TransactionImportPort port = new TransactionImportPort() {
            @Override
            public void storeValid(ImportedTransaction transaction) {
                valid.incrementAndGet();
            }

            @Override
            public void storeRejected(ImportedTransaction transaction, String reason) {
            }
        };
        var registry = new SimpleMeterRegistry();
        var writer = new TransactionImportItemWriter(port, new BatchImportMetrics(registry));

        writer.write(Chunk.of(
                new ImportedTransaction("tx-1", LocalDate.now(), BigDecimal.TEN, "EUR", "cust"),
                new ImportedTransaction("tx-2", LocalDate.now(), BigDecimal.ONE, "USD", "cust")
        ));

        assertThat(valid).hasValue(2);
        assertThat(registry.get("batch_transactions_total")
                .tag("result", "valid")
                .counter()
                .count()).isEqualTo(2.0);
    }
}
