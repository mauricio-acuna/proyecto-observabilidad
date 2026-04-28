package com.proyecto2027.notificationhub.infrastructure;

import com.proyecto2027.notificationhub.infrastructure.persistence.DeadLetterEventRecorder;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.ObjectProvider;

import java.nio.charset.StandardCharsets;
import java.util.function.Consumer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

class RabbitDeadLetterListenerTest {

    private final DeadLetterEventRecorder recorder = mock(DeadLetterEventRecorder.class);
    private final ObjectProvider<DeadLetterEventRecorder> provider = mock(ObjectProvider.class);
    private final RabbitDeadLetterListener listener = new RabbitDeadLetterListener(provider);

    @Test
    void recordsDeadLetterPayload() {
        MessageProperties properties = new MessageProperties();
        properties.setHeader("x-first-death-reason", "rejected");
        Message message = new Message("{\"eventId\":\"123\"}".getBytes(StandardCharsets.UTF_8), properties);
        doAnswer(invocation -> {
            Consumer<DeadLetterEventRecorder> consumer = invocation.getArgument(0);
            consumer.accept(recorder);
            return null;
        }).when(provider).ifAvailable(org.mockito.ArgumentMatchers.<Consumer<DeadLetterEventRecorder>>any());

        listener.consume(message);

        verify(recorder).record(
                RabbitNotificationConfiguration.TICKET_CREATED_DLQ,
                "{\"eventId\":\"123\"}",
                "rejected"
        );
    }
}
