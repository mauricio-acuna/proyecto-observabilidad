package com.proyecto2027.notificationhub.infrastructure.persistence;

import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class NotificationHubMetricsTest {

    private final NotificationOperationsQuery query = mock(NotificationOperationsQuery.class);
    private final NotificationHubMetrics metrics = new NotificationHubMetrics(query);

    @Test
    void registersOperationalGauges() {
        when(query.snapshot()).thenReturn(new NotificationOperationsQuery.NotificationOperationsSnapshot(
                10L,
                12L,
                9L,
                3L,
                2L
        ));
        SimpleMeterRegistry registry = new SimpleMeterRegistry();

        metrics.bindTo(registry);

        assertThat(registry.get("notification_hub_processed_events_total").gauge().value()).isEqualTo(10.0);
        assertThat(registry.get("notification_hub_attempts_total").gauge().value()).isEqualTo(12.0);
        assertThat(registry.get("notification_hub_sent_notifications_total").gauge().value()).isEqualTo(9.0);
        assertThat(registry.get("notification_hub_failed_notifications_total").gauge().value()).isEqualTo(3.0);
        assertThat(registry.get("notification_hub_dead_letter_events_total").gauge().value()).isEqualTo(2.0);
    }
}
