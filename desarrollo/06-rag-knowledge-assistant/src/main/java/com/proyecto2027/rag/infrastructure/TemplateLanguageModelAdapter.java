package com.proyecto2027.rag.infrastructure;

import com.proyecto2027.rag.application.LanguageModelPort;
import com.proyecto2027.rag.domain.DocumentChunk;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TemplateLanguageModelAdapter implements LanguageModelPort {
    @Override
    public String generateAnswer(String question, List<DocumentChunk> context) {
        return "Based on internal procedures: " + context.get(0).content();
    }
}
