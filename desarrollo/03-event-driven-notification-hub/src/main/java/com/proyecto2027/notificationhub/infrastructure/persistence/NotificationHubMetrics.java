package com.proyecto2027.notificationhub.infrastructure.persistence;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!in-memory")
public class NotificationHubMetrics implements MeterBinder {

    private final NotificationOperationsQuery query;

    public NotificationHubMetrics(NotificationOperationsQuery query) {
        this.query = query;
    }

    @Override
    public void bindTo(MeterRegistry registry) {
        Gauge.builder("notification_hub_processed_events_total", query, value -> value.snapshot().processedEvents())
                .description("Total processed notification events")
                .register(registry);
        Gauge.builder("notification_hub_attempts_total", query, value -> value.snapshot().notificationAttempts())
                .description("Total notification attempts")
                .register(registry);
        Gauge.builder("notification_hub_sent_notifications_total", query, value -> value.snapshot().sentNotifications())
                .description("Total sent notifications")
                .register(registry);
        Gauge.builder("notification_hub_failed_notifications_total", query, value -> value.snapshot().failedNotifications())
                .description("Total failed notification attempts")
                .register(registry);
        Gauge.builder("notification_hub_dead_letter_events_total", query, value -> value.snapshot().deadLetterEvents())
                .description("Total persisted dead-letter events")
                .register(registry);
    }
}
