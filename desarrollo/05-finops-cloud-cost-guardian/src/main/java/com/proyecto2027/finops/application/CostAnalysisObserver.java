package com.proyecto2027.finops.application;

import com.proyecto2027.finops.domain.CloudCostRecord;
import com.proyecto2027.finops.domain.CostRecommendation;

import java.util.List;

public interface CostAnalysisObserver {
    void recordAnalysis(List<CloudCostRecord> records, List<CostRecommendation> recommendations);
}
