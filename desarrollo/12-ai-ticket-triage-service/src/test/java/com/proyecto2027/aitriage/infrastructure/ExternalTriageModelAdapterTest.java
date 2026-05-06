package com.proyecto2027.aitriage.infrastructure;

import com.proyecto2027.aitriage.domain.TicketTriageRequest;
import org.junit.jupiter.api.Test;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestClient;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.ExpectedCount.once;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.header;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withServerError;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpMethod.POST;

class ExternalTriageModelAdapterTest {

    @Test
    void mapsStructuredProviderResponse() {
        RestClient.Builder builder = RestClient.builder();
        MockRestServiceServer server = MockRestServiceServer.bindTo(builder).build();
        var adapter = new ExternalTriageModelAdapter(
                builder,
                new RuleBasedTriageModelAdapter(),
                new TriageProviderMetrics(new SimpleMeterRegistry()),
                new SensitiveDataRedactor(),
                "http://llm-provider.test",
                "secret"
        );

        server.expect(once(), requestTo("http://llm-provider.test/v1/triage"))
                .andExpect(method(POST))
                .andExpect(header(AUTHORIZATION, "Bearer secret"))
                .andRespond(withSuccess("""
                        {
                          "category": "FRAUD",
                          "priority": "CRITICAL",
                          "extractedEntities": ["wire-transfer"],
                          "summary": "Possible unauthorized transfer",
                          "nextAction": "Escalate to fraud operations",
                          "promptVersion": "triage-v1"
                        }
                        """, MediaType.APPLICATION_JSON));

        var result = adapter.classify(
                new TicketTriageRequest("Suspicious transfer", "I see an unknown wire transfer", "premium"),
                "triage-v1"
        );

        assertThat(result.category()).isEqualTo("FRAUD");
        assertThat(result.priority()).isEqualTo("CRITICAL");
        assertThat(result.extractedEntities()).containsExactly("wire-transfer");
        assertThat(result.nextAction()).isEqualTo("Escalate to fraud operations");
        server.verify();
    }

    @Test
    void fallsBackToRulesWhenProviderFails() {
        RestClient.Builder builder = RestClient.builder();
        MockRestServiceServer server = MockRestServiceServer.bindTo(builder).build();
        var adapter = new ExternalTriageModelAdapter(
                builder,
                new RuleBasedTriageModelAdapter(),
                new TriageProviderMetrics(new SimpleMeterRegistry()),
                new SensitiveDataRedactor(),
                "http://llm-provider.test",
                ""
        );

        server.expect(once(), requestTo("http://llm-provider.test/v1/triage"))
                .andRespond(withServerError());

        var result = adapter.classify(
                new TicketTriageRequest("Blocked card", "My card is blocked", "premium"),
                "triage-v1"
        );

        assertThat(result.category()).isEqualTo("CARDS");
        assertThat(result.priority()).isEqualTo("HIGH");
        assertThat(result.promptVersion()).isEqualTo("triage-v1");
        server.verify();
    }

    @Test
    void redactsSensitiveDataBeforeCallingProvider() {
        RestClient.Builder builder = RestClient.builder();
        MockRestServiceServer server = MockRestServiceServer.bindTo(builder).build();
        var adapter = new ExternalTriageModelAdapter(
                builder,
                new RuleBasedTriageModelAdapter(),
                new TriageProviderMetrics(new SimpleMeterRegistry()),
                new SensitiveDataRedactor(),
                "http://llm-provider.test",
                ""
        );

        server.expect(once(), requestTo("http://llm-provider.test/v1/triage"))
                .andExpect(content().string(allOf(
                        containsString("[REDACTED_EMAIL]"),
                        containsString("[REDACTED_CARD]"),
                        containsString("[REDACTED_DOCUMENT]"),
                        not(containsString("client@example.com")),
                        not(containsString("4111 1111 1111 1111")),
                        not(containsString("DNI 12345678"))
                )))
                .andRespond(withSuccess("""
                        {
                          "category": "CARDS",
                          "priority": "HIGH",
                          "extractedEntities": [],
                          "summary": "Redacted card issue",
                          "nextAction": "Review card status",
                          "promptVersion": "triage-v1"
                        }
                        """, MediaType.APPLICATION_JSON));

        adapter.classify(
                new TicketTriageRequest(
                        "Card blocked for client@example.com",
                        "Card 4111 1111 1111 1111 failed. DNI 12345678",
                        "premium"
                ),
                "triage-v1"
        );

        server.verify();
    }
}
