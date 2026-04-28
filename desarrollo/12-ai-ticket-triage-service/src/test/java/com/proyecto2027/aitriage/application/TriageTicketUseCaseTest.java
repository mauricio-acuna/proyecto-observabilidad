package com.proyecto2027.aitriage.application;

import com.proyecto2027.aitriage.domain.TicketTriageRequest;
import com.proyecto2027.aitriage.infrastructure.RuleBasedTriageModelAdapter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TriageTicketUseCaseTest {

    @Test
    void returnsStructuredClassificationWithPromptVersion() {
        var useCase = new TriageTicketUseCase(new RuleBasedTriageModelAdapter());

        var result = useCase.execute(new TicketTriageRequest("Blocked card", "My card is blocked", "premium"));

        assertThat(result.category()).isEqualTo("CARDS");
        assertThat(result.priority()).isEqualTo("HIGH");
        assertThat(result.promptVersion()).isEqualTo("triage-v1");
    }
}
