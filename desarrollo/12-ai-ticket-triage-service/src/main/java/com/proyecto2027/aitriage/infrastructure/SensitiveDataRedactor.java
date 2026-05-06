package com.proyecto2027.aitriage.infrastructure;

import com.proyecto2027.aitriage.domain.TicketTriageRequest;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class SensitiveDataRedactor {

    private static final Pattern EMAIL = Pattern.compile("\\b[\\w.%+-]+@[\\w.-]+\\.[A-Za-z]{2,}\\b");
    private static final Pattern CARD_NUMBER = Pattern.compile("\\b(?:\\d[ -]?){13,19}\\b");
    private static final Pattern DOCUMENT_NUMBER = Pattern.compile("(?i)\\b(?:dni|rut|ssn|document|documento)[:#\\s-]*[A-Z0-9.-]{5,}\\b");
    private static final Pattern PHONE_NUMBER = Pattern.compile("\\b(?:\\+?\\d{1,3}[ -]?)?(?:\\(?\\d{2,4}\\)?[ -]?)?\\d{3,4}[ -]?\\d{4}\\b");

    TicketTriageRequest redact(TicketTriageRequest request) {
        return new TicketTriageRequest(
                redactText(request.subject()),
                redactText(request.description()),
                redactText(request.customerSegment())
        );
    }

    String redactText(String value) {
        if (value == null || value.isBlank()) {
            return value;
        }
        String redacted = EMAIL.matcher(value).replaceAll("[REDACTED_EMAIL]");
        redacted = CARD_NUMBER.matcher(redacted).replaceAll("[REDACTED_CARD]");
        redacted = DOCUMENT_NUMBER.matcher(redacted).replaceAll("[REDACTED_DOCUMENT]");
        redacted = PHONE_NUMBER.matcher(redacted).replaceAll("[REDACTED_PHONE]");
        return redacted;
    }
}
