package com.proyecto2027.finops.infrastructure;

import com.proyecto2027.finops.application.CostProviderPort;
import com.proyecto2027.finops.domain.CloudCostRecord;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
@ConditionalOnProperty(name = "app.finops.provider", havingValue = "simulated", matchIfMissing = true)
public class SimulatedAwsCostProvider implements CostProviderPort {
    @Override
    public List<CloudCostRecord> fetchCosts(LocalDate from, LocalDate to) {
        return List.of(
                new CloudCostRecord(from, "banking-dev", "ECS", "prod", new BigDecimal("720")),
                new CloudCostRecord(from, "banking-dev", "RDS", "prod", new BigDecimal("980")),
                new CloudCostRecord(from, "banking-dev", "CloudWatch", "prod", new BigDecimal("230"))
        );
    }
}
