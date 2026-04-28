package com.proyecto2027.finops.application;

import com.proyecto2027.finops.domain.CloudCostRecord;

import java.time.LocalDate;
import java.util.List;

public interface CostProviderPort {
    List<CloudCostRecord> fetchCosts(LocalDate from, LocalDate to);
}
