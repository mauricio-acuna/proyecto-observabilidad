package com.proyecto2027.finops.infrastructure;

import com.proyecto2027.finops.application.CostProviderPort;
import com.proyecto2027.finops.domain.CloudCostRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
@ConditionalOnProperty(name = "app.finops.provider", havingValue = "aws-http")
public class AwsCostExplorerHttpProvider implements CostProviderPort {

    private final RestClient restClient;
    private final CostProviderPort fallback;

    public AwsCostExplorerHttpProvider(
            RestClient.Builder restClientBuilder,
            @Value("${app.finops.aws.base-url}") String baseUrl,
            @Value("${app.finops.aws.api-key:}") String apiKey
    ) {
        this(restClientBuilder, new SimulatedAwsCostProvider(), baseUrl, apiKey);
    }

    AwsCostExplorerHttpProvider(
            RestClient.Builder restClientBuilder,
            CostProviderPort fallback,
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
    public List<CloudCostRecord> fetchCosts(LocalDate from, LocalDate to) {
        try {
            CloudCostRecord[] records = restClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/cost-explorer/costs")
                            .queryParam("from", from)
                            .queryParam("to", to)
                            .build())
                    .retrieve()
                    .body(CloudCostRecord[].class);

            if (records == null || records.length == 0) {
                return fallback.fetchCosts(from, to);
            }
            return Arrays.asList(records);
        } catch (RestClientException ex) {
            return fallback.fetchCosts(from, to);
        }
    }
}
