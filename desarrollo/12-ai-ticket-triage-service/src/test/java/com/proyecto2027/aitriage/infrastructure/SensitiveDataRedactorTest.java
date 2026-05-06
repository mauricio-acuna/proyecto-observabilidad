package com.proyecto2027.aitriage.infrastructure;

import com.proyecto2027.aitriage.domain.TicketTriageRequest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SensitiveDataRedactorTest {

    @Test
    void redactsCommonSensitiveValues() {
        var redactor = new SensitiveDataRedactor();

        var redacted = redactor.redact(new TicketTriageRequest(
                "Customer john.doe@example.com called",
                "DNI 12345678, card 4111-1111-1111-1111 and phone +56 9 1234 5678",
                "premium"
        ));

        assertThat(redacted.subject()).contains("[REDACTED_EMAIL]");
        assertThat(redacted.description()).contains("[REDACTED_DOCUMENT]");
        assertThat(redacted.description()).contains("[REDACTED_CARD]");
        assertThat(redacted.description()).contains("[REDACTED_PHONE]");
        assertThat(redacted.description()).doesNotContain("12345678", "4111", "1234 5678");
    }
}
