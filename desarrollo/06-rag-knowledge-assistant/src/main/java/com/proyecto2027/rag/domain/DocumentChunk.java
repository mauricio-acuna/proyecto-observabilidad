package com.proyecto2027.rag.domain;

import java.util.Map;
import java.util.UUID;

public record DocumentChunk(
        UUID id,
        String documentId,
        String content,
        Map<String, String> metadata
) {
}
