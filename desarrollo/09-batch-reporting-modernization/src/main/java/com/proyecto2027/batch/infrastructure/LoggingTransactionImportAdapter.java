package com.proyecto2027.batch.infrastructure;

import com.proyecto2027.batch.application.TransactionImportPort;
import com.proyecto2027.batch.domain.ImportedTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggingTransactionImportAdapter implements TransactionImportPort {

    private static final Logger log = LoggerFactory.getLogger(LoggingTransactionImportAdapter.class);

    @Override
    public void storeValid(ImportedTransaction transaction) {
        log.info("batch_valid_transaction externalId={} amount={}", transaction.externalId(), transaction.amount());
    }

    @Override
    public void storeRejected(ImportedTransaction transaction, String reason) {
        log.warn("batch_rejected_transaction externalId={} reason={}", transaction.externalId(), reason);
    }
}
