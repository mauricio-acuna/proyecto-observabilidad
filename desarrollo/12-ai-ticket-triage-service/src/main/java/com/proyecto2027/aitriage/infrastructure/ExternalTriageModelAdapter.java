package com.proyecto2027.aitriage.infrastructure;

import com.proyecto2027.aitriage.application.TriageModelPort;
import com.proyecto2027.aitriage.domain.TicketTriageRequest;
import com.proyecto2027.aitriage.domain.TriageResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import java.util.List;

@Component
@ConditionalOnProperty(name = "app.ai.provider", havingValue = "external")
public class ExternalTriageModelAdapter implements TriageModelPort {

    private final RestClient restClient;
    private final RuleBasedTriageModelAdapter fallback;

    public ExternalTriageModelAdapter(
            RestClient.Builder restClientBuilder,
            @Value("${app.ai.external.base-url}") String baseUrl,
            @Value("${app.ai.external.api-key:}") String apiKey
    ) {
        this(restClientBuilder, new RuleBasedTriageModelAdapter(), baseUrl, apiKey);
    }

    ExternalTriageModelAdapter(
            RestClient.Builder restClientBuilder,
            RuleBasedTriageModelAdapter fallback,
            String baseUrl,
            String apiKey
    ) {
        RestClient.Builder builder = restClientBuilder.baseUrl(baseUrl);
        if (apiKey != null && !apiKey.isBlank()) {
            builder.defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey);
        }
        this.restClient = builder.build();
        this.fallback = fallback;
    }

    @Override
    public TriageResult classify(TicketTriageRequest request, String promptVersion) {
        try {
            TriageResult result = restClient.post()
                    .uri("/v1/triage")
                    .body(new ExternalTriageRequest(request, promptVersion))
                    .retrieve()
                    .body(TriageResult.class);

            if (!isValid(result)) {
                return fallback.classify(request, promptVersion);
            }
            return ensurePromptVersion(result, promptVersion);
        } catch (RestClientException ex) {
            return fallback.classify(request, promptVersion);
        }
    }

    private static boolean isValid(TriageResult result) {
        return result != null
                && hasText(result.category())
                && hasText(result.priority())
                && hasText(result.summary())
                && hasText(result.nextAction());
    }

    private static boolean hasText(String value) {
        return value != null && !value.isBlank();
    }

    private static TriageResult ensurePromptVersion(TriageResult result, String promptVersion) {
        if (hasText(result.promptVersion())) {
            return result;
        }
        List<String> entities = result.extractedEntities() == null ? List.of() : result.extractedEntities();
        return new TriageResult(
                result.category(),
                result.priority(),
                entities,
                result.summary(),
                result.nextAction(),
                promptVersion
        );
    }

    private record ExternalTriageRequest(
            TicketTriageRequest ticket,
            String promptVersion
    ) {
    }
}
