package com.proyecto2027.batch.infrastructure;

import com.proyecto2027.batch.application.ValidateTransactionUseCase;
import com.proyecto2027.batch.domain.ImportedTransaction;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/batch/transactions")
public class BatchPreviewController {

    private final ValidateTransactionUseCase validateTransactionUseCase;

    public BatchPreviewController(ValidateTransactionUseCase validateTransactionUseCase) {
        this.validateTransactionUseCase = validateTransactionUseCase;
    }

    @PostMapping("/preview")
    public String preview(@RequestBody ImportedTransaction transaction) {
        validateTransactionUseCase.execute(transaction);
        return "processed";
    }
}
