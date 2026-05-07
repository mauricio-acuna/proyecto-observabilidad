package com.proyecto2027.batch.infrastructure;

import com.proyecto2027.batch.application.TransactionImportPort;
import com.proyecto2027.batch.domain.ImportedTransaction;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class TransactionValidationItemProcessor implements ItemProcessor<ImportedTransaction, ImportedTransaction> {

    private final TransactionImportPort importPort;
    private final BatchImportMetrics metrics;

    public TransactionValidationItemProcessor(TransactionImportPort importPort, BatchImportMetrics metrics) {
        this.importPort = importPort;
        this.metrics = metrics;
    }

    @Override
    public ImportedTransaction process(ImportedTransaction item) {
        if (item.isValid()) {
            return item;
        }
        importPort.storeRejected(item, "Invalid transaction fields");
        metrics.recordRejected();
        return null;
    }
}
