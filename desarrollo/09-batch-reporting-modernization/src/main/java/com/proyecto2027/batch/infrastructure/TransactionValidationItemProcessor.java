package com.proyecto2027.batch.infrastructure;

import com.proyecto2027.batch.application.TransactionImportPort;
import com.proyecto2027.batch.domain.ImportedTransaction;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class TransactionValidationItemProcessor implements ItemProcessor<ImportedTransaction, ImportedTransaction> {

    private final TransactionImportPort importPort;

    public TransactionValidationItemProcessor(TransactionImportPort importPort) {
        this.importPort = importPort;
    }

    @Override
    public ImportedTransaction process(ImportedTransaction item) {
        if (item.isValid()) {
            return item;
        }
        importPort.storeRejected(item, "Invalid transaction fields");
        return null;
    }
}
