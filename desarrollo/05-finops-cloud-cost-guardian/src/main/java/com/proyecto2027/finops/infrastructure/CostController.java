package com.proyecto2027.finops.infrastructure;

import com.proyecto2027.finops.application.AnalyzeCostUseCase;
import com.proyecto2027.finops.application.EvaluateBudgetAlertsUseCase;
import com.proyecto2027.finops.domain.BudgetAlert;
import com.proyecto2027.finops.domain.CostRecommendation;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/costs")
public class CostController {

    private final AnalyzeCostUseCase analyzeCostUseCase;
    private final EvaluateBudgetAlertsUseCase evaluateBudgetAlertsUseCase;

    public CostController(
            AnalyzeCostUseCase analyzeCostUseCase,
            EvaluateBudgetAlertsUseCase evaluateBudgetAlertsUseCase
    ) {
        this.analyzeCostUseCase = analyzeCostUseCase;
        this.evaluateBudgetAlertsUseCase = evaluateBudgetAlertsUseCase;
    }

    @GetMapping("/recommendations")
    public List<CostRecommendation> recommendations(
            @RequestParam LocalDate from,
            @RequestParam LocalDate to
    ) {
        return analyzeCostUseCase.execute(from, to);
    }

    @GetMapping("/budget-alerts")
    public List<BudgetAlert> budgetAlerts(
            @RequestParam LocalDate from,
            @RequestParam LocalDate to
    ) {
        return evaluateBudgetAlertsUseCase.execute(from, to);
    }
}
