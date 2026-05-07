package com.proyecto2027.batch.infrastructure;

import com.proyecto2027.batch.domain.ImportedTransaction;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Configuration
@ConditionalOnBean(JobRepository.class)
public class TransactionImportBatchConfiguration {

    @Bean
    Job transactionImportJob(JobRepository jobRepository, Step validateTransactionsStep) {
        return new JobBuilder("transactionImportJob", jobRepository)
                .start(validateTransactionsStep)
                .build();
    }

    @Bean
    Step validateTransactionsStep(
            JobRepository jobRepository,
            PlatformTransactionManager transactionManager,
            ItemReader<ImportedTransaction> transactionItemReader,
            TransactionValidationItemProcessor processor,
            TransactionImportItemWriter writer
    ) {
        return new StepBuilder("validateTransactionsStep", jobRepository)
                .<ImportedTransaction, ImportedTransaction>chunk(10, transactionManager)
                .reader(transactionItemReader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    ItemReader<ImportedTransaction> transactionItemReader() {
        return new ListItemReader<>(List.of(
                new ImportedTransaction("batch-tx-1", LocalDate.now(), new BigDecimal("120.50"), "EUR", "customer-1"),
                new ImportedTransaction("batch-tx-2", LocalDate.now(), new BigDecimal("-10.00"), "EUR", "customer-2"),
                new ImportedTransaction("batch-tx-3", LocalDate.now(), new BigDecimal("77.20"), "USD", "customer-3")
        ));
    }
}
