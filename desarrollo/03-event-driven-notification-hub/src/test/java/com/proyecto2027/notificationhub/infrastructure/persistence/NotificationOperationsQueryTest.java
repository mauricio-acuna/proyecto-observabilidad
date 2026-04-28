package com.proyecto2027.notificationhub.infrastructure.persistence;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class NotificationOperationsQueryTest {

    private final SpringDataProcessedEventRepository processedEvents = mock(SpringDataProcessedEventRepository.class);
    private final SpringDataNotificationAttemptRepository attempts = mock(SpringDataNotificationAttemptRepository.class);
    private final SpringDataDeadLetterEventRepository deadLetters = mock(SpringDataDeadLetterEventRepository.class);
    private final NotificationOperationsQuery query = new NotificationOperationsQuery(processedEvents, attempts, deadLetters);

    @Test
    void buildsOperationalSnapshotFromRepositories() {
        when(processedEvents.count()).thenReturn(10L);
        when(attempts.count()).thenReturn(12L);
        when(attempts.countByStatus(NotificationAttemptStatus.SENT)).thenReturn(9L);
        when(attempts.countByStatus(NotificationAttemptStatus.FAILED)).thenReturn(3L);
        when(deadLetters.count()).thenReturn(2L);

        var snapshot = query.snapshot();

        assertThat(snapshot.processedEvents()).isEqualTo(10L);
        assertThat(snapshot.notificationAttempts()).isEqualTo(12L);
        assertThat(snapshot.sentNotifications()).isEqualTo(9L);
        assertThat(snapshot.failedNotifications()).isEqualTo(3L);
        assertThat(snapshot.deadLetterEvents()).isEqualTo(2L);
    }
}
