package com.proyecto2027.rag.application;

import com.proyecto2027.rag.domain.Answer;
import com.proyecto2027.rag.domain.DocumentChunk;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AskKnowledgeBaseUseCase {

    private final VectorSearchPort vectorSearch;
    private final LanguageModelPort languageModel;

    public AskKnowledgeBaseUseCase(VectorSearchPort vectorSearch, LanguageModelPort languageModel) {
        this.vectorSearch = vectorSearch;
        this.languageModel = languageModel;
    }

    public Answer execute(String question) {
        List<DocumentChunk> chunks = vectorSearch.searchSimilar(question, 5);
        if (chunks.isEmpty()) {
            return new Answer("I do not have enough evidence to answer.", List.of(), false);
        }
        String generated = languageModel.generateAnswer(question, chunks);
        List<String> citations = chunks.stream().map(DocumentChunk::documentId).distinct().toList();
        return new Answer(generated, citations, true);
    }
}
