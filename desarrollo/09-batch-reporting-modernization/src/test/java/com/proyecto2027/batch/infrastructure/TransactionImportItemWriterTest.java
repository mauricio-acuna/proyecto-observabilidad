package com.proyecto2027.batch.infrastructure;

import com.proyecto2027.batch.application.TransactionImportPort;
import com.proyecto2027.batch.domain.ImportedTransaction;
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
        var writer = new TransactionImportItemWriter(port);

        writer.write(Chunk.of(
                new ImportedTransaction("tx-1", LocalDate.now(), BigDecimal.TEN, "EUR", "cust"),
                new ImportedTransaction("tx-2", LocalDate.now(), BigDecimal.ONE, "USD", "cust")
        ));

        assertThat(valid).hasValue(2);
    }
}
