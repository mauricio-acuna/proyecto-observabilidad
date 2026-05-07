package com.proyecto2027.batch.infrastructure;

import com.proyecto2027.batch.application.TransactionImportPort;
import com.proyecto2027.batch.domain.ImportedTransaction;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
public class TransactionImportItemWriter implements ItemWriter<ImportedTransaction> {

    private final TransactionImportPort importPort;

    public TransactionImportItemWriter(TransactionImportPort importPort) {
        this.importPort = importPort;
    }

    @Override
    public void write(Chunk<? extends ImportedTransaction> chunk) {
        chunk.forEach(importPort::storeValid);
    }
}
