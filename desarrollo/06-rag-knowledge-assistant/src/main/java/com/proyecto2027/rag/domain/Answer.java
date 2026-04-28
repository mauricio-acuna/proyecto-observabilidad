package com.proyecto2027.rag.domain;

import java.util.List;

public record Answer(
        String text,
        List<String> citations,
        boolean evidenceFound
) {
}
