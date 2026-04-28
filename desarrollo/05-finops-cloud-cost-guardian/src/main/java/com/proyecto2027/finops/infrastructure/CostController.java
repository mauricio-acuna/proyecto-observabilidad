package com.proyecto2027.finops.infrastructure;

import com.proyecto2027.finops.application.AnalyzeCostUseCase;
import com.proyecto2027.finops.domain.CostRecommendation;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/costs")
public class CostController {

    private final AnalyzeCostUseCase analyzeCostUseCase;

    public CostController(AnalyzeCostUseCase analyzeCostUseCase) {
        this.analyzeCostUseCase = analyzeCostUseCase;
    }

    @GetMapping("/recommendations")
    public List<CostRecommendation> recommendations(
            @RequestParam LocalDate from,
            @RequestParam LocalDate to
    ) {
        return analyzeCostUseCase.execute(from, to);
    }
}
