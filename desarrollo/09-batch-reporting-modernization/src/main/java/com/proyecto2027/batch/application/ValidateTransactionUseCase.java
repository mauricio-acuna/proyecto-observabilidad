package com.proyecto2027.batch.application;

import com.proyecto2027.batch.domain.ImportedTransaction;
import org.springframework.stereotype.Service;

@Service
public class ValidateTransactionUseCase {

    private final TransactionImportPort importPort;

    public ValidateTransactionUseCase(TransactionImportPort importPort) {
        this.importPort = importPort;
    }

    public void execute(ImportedTransaction transaction) {
        if (transaction.isValid()) {
            importPort.storeValid(transaction);
        } else {
            importPort.storeRejected(transaction, "Invalid transaction fields");
        }
    }
}
