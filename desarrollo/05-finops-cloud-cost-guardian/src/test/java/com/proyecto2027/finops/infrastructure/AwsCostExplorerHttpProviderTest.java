package com.proyecto2027.finops.infrastructure;

import com.proyecto2027.finops.domain.CloudCostRecord;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestClient;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.ExpectedCount.once;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.header;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withServerError;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

class AwsCostExplorerHttpProviderTest {

    @Test
    void mapsCostExplorerRecords() {
        RestClient.Builder builder = RestClient.builder();
        MockRestServiceServer server = MockRestServiceServer.bindTo(builder).build();
        var provider = new AwsCostExplorerHttpProvider(
                builder,
                (from, to) -> List.of(),
                "http://cost-explorer.test",
                "secret"
        );

        server.expect(once(), requestTo("http://cost-explorer.test/cost-explorer/costs?from=2026-05-01&to=2026-05-06"))
                .andExpect(method(GET))
                .andExpect(header(AUTHORIZATION, "Bearer secret"))
                .andRespond(withSuccess("""
                        [
                          {
                            "date": "2026-05-01",
                            "account": "banking-prod",
                            "service": "RDS",
                            "environment": "prod",
                            "amountUsd": 840.50
                          }
                        ]
                        """, MediaType.APPLICATION_JSON));

        List<CloudCostRecord> records = provider.fetchCosts(LocalDate.parse("2026-05-01"), LocalDate.parse("2026-05-06"));

        assertThat(records).hasSize(1);
        assertThat(records.get(0).service()).isEqualTo("RDS");
        assertThat(records.get(0).amountUsd()).isEqualByComparingTo(new BigDecimal("840.50"));
        server.verify();
    }

    @Test
    void fallsBackWhenCostExplorerFails() {
        RestClient.Builder builder = RestClient.builder();
        MockRestServiceServer server = MockRestServiceServer.bindTo(builder).build();
        var fallbackRecord = new CloudCostRecord(
                LocalDate.parse("2026-05-01"),
                "fallback",
                "ECS",
                "prod",
                new BigDecimal("600")
        );
        var provider = new AwsCostExplorerHttpProvider(
                builder,
                (from, to) -> List.of(fallbackRecord),
                "http://cost-explorer.test",
                ""
        );

        server.expect(once(), requestTo("http://cost-explorer.test/cost-explorer/costs?from=2026-05-01&to=2026-05-06"))
                .andRespond(withServerError());

        List<CloudCostRecord> records = provider.fetchCosts(LocalDate.parse("2026-05-01"), LocalDate.parse("2026-05-06"));

        assertThat(records).containsExactly(fallbackRecord);
        server.verify();
    }
}
