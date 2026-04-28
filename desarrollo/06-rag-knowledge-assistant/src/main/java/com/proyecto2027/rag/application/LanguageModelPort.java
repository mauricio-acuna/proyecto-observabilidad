package com.proyecto2027.rag.application;

import com.proyecto2027.rag.domain.DocumentChunk;

import java.util.List;

public interface LanguageModelPort {
    String generateAnswer(String question, List<DocumentChunk> context);
}
