package com.proyecto2027.rag.infrastructure;

import com.proyecto2027.rag.application.VectorSearchPort;
import com.proyecto2027.rag.domain.DocumentChunk;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class InMemoryVectorSearchAdapter implements VectorSearchPort {
    @Override
    public List<DocumentChunk> searchSimilar(String question, int topK) {
        if (!question.toLowerCase().contains("card")) {
            return List.of();
        }
        return List.of(new DocumentChunk(
                UUID.randomUUID(),
                "support-card-procedure",
                "When a card is blocked, verify customer identity and check fraud flags before reactivation.",
                Map.of("domain", "cards")
        ));
    }
}
