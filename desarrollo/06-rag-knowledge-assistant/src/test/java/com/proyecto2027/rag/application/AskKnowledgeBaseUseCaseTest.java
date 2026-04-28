package com.proyecto2027.rag.application;

import com.proyecto2027.rag.domain.DocumentChunk;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class AskKnowledgeBaseUseCaseTest {

    @Test
    void refusesToAnswerWhenNoEvidenceIsFound() {
        var useCase = new AskKnowledgeBaseUseCase((question, topK) -> List.of(), (question, context) -> "unused");

        var answer = useCase.execute("unknown question");

        assertThat(answer.evidenceFound()).isFalse();
        assertThat(answer.citations()).isEmpty();
    }

    @Test
    void answersWithCitationsWhenEvidenceExists() {
        VectorSearchPort search = (question, topK) -> List.of(
                new DocumentChunk(UUID.randomUUID(), "doc-1", "Procedure content", Map.of())
        );
        LanguageModelPort model = (question, context) -> "Generated answer";

        var answer = new AskKnowledgeBaseUseCase(search, model).execute("card procedure");

        assertThat(answer.evidenceFound()).isTrue();
        assertThat(answer.citations()).containsExactly("doc-1");
    }
}
