package com.proyecto2027.batch.application;

import com.proyecto2027.batch.domain.ImportedTransaction;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateTransactionUseCaseTest {

    @Test
    void storesValidTransactionsSeparatelyFromRejectedOnes() {
        AtomicInteger valid = new AtomicInteger();
        AtomicInteger rejected = new AtomicInteger();
        TransactionImportPort port = new TransactionImportPort() {
            @Override
            public void storeValid(ImportedTransaction transaction) {
                valid.incrementAndGet();
            }

            @Override
            public void storeRejected(ImportedTransaction transaction, String reason) {
                rejected.incrementAndGet();
            }
        };
        var useCase = new ValidateTransactionUseCase(port);

        useCase.execute(new ImportedTransaction("tx-1", LocalDate.now(), BigDecimal.TEN, "EUR", "cust"));
        useCase.execute(new ImportedTransaction("tx-2", LocalDate.now(), BigDecimal.TEN.negate(), "EUR", "cust"));

        assertThat(valid).hasValue(1);
        assertThat(rejected).hasValue(1);
    }
}
