package com.proyecto2027.notificationhub.infrastructure.persistence;

import com.proyecto2027.notificationhub.application.ProcessedEventStore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(JpaProcessedEventStore.class)
@Testcontainers(disabledWithoutDocker = true)
class JpaProcessedEventStoreTest {

    @Container
    static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine")
            .withDatabaseName("proyecto2027")
            .withUsername("proyecto2027")
            .withPassword("proyecto2027");

    @DynamicPropertySource
    static void datasourceProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    private final ProcessedEventStore store;

    @Autowired
    JpaProcessedEventStoreTest(ProcessedEventStore store) {
        this.store = store;
    }

    @Test
    void persistsProcessedEventIds() {
        UUID eventId = UUID.randomUUID();

        assertThat(store.wasProcessed(eventId)).isFalse();

        store.markProcessed(eventId);

        assertThat(store.wasProcessed(eventId)).isTrue();
    }
}
