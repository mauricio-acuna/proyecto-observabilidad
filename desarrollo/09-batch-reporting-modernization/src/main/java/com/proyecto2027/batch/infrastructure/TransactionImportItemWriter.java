package com.proyecto2027.batch.infrastructure;

import com.proyecto2027.batch.application.TransactionImportPort;
import com.proyecto2027.batch.domain.ImportedTransaction;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
public class TransactionImportItemWriter implements ItemWriter<ImportedTransaction> {

    private final TransactionImportPort importPort;
    private final BatchImportMetrics metrics;

    public TransactionImportItemWriter(TransactionImportPort importPort, BatchImportMetrics metrics) {
        this.importPort = importPort;
        this.metrics = metrics;
    }

    @Override
    public void write(Chunk<? extends ImportedTransaction> chunk) {
        chunk.forEach(transaction -> {
            importPort.storeValid(transaction);
            metrics.recordValid();
        });
    }
}
