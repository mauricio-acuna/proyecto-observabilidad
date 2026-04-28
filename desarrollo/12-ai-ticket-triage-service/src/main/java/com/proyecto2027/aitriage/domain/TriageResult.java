package com.proyecto2027.aitriage.domain;

import java.util.List;

public record TriageResult(
        String category,
        String priority,
        List<String> extractedEntities,
        String summary,
        String nextAction,
        String promptVersion
) {
}
