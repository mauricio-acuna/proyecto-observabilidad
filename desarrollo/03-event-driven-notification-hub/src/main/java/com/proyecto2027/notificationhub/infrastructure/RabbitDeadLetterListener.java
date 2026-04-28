package com.proyecto2027.notificationhub.infrastructure;

import com.proyecto2027.notificationhub.infrastructure.persistence.DeadLetterEventRecorder;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class RabbitDeadLetterListener {

    private final ObjectProvider<DeadLetterEventRecorder> recorder;

    public RabbitDeadLetterListener(ObjectProvider<DeadLetterEventRecorder> recorder) {
        this.recorder = recorder;
    }

    @RabbitListener(queues = RabbitNotificationConfiguration.TICKET_CREATED_DLQ)
    public void consume(Message message) {
        String payload = new String(message.getBody(), StandardCharsets.UTF_8);
        String reason = String.valueOf(message.getMessageProperties().getHeaders().getOrDefault("x-first-death-reason", "unknown"));
        recorder.ifAvailable(deadLetters ->
                deadLetters.record(RabbitNotificationConfiguration.TICKET_CREATED_DLQ, payload, reason)
        );
    }
}
