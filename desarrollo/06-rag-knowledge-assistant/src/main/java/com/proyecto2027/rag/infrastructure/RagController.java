package com.proyecto2027.rag.infrastructure;

import com.proyecto2027.rag.application.AskKnowledgeBaseUseCase;
import com.proyecto2027.rag.domain.Answer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/knowledge")
public class RagController {

    private final AskKnowledgeBaseUseCase useCase;

    public RagController(AskKnowledgeBaseUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/ask")
    public Answer ask(@RequestBody QuestionRequest request) {
        return useCase.execute(request.question());
    }

    public record QuestionRequest(String question) {
    }
}
