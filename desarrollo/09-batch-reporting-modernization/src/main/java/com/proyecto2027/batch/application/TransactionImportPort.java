package com.proyecto2027.batch.application;

import com.proyecto2027.batch.domain.ImportedTransaction;

public interface TransactionImportPort {
    void storeValid(ImportedTransaction transaction);

    void storeRejected(ImportedTransaction transaction, String reason);
}
