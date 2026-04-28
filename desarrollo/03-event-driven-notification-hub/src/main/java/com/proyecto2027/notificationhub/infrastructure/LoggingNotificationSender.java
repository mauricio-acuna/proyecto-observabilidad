package com.proyecto2027.notificationhub.infrastructure;

import com.proyecto2027.notificationhub.application.NotificationSender;
import com.proyecto2027.notificationhub.domain.NotificationEvent;
import com.proyecto2027.notificationhub.infrastructure.persistence.NotificationAttemptRecorder;
import org.springframework.beans.factory.ObjectProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggingNotificationSender implements NotificationSender {

    private static final Logger log = LoggerFactory.getLogger(LoggingNotificationSender.class);
    private final ObjectProvider<NotificationAttemptRecorder> attemptRecorder;

    public LoggingNotificationSender(ObjectProvider<NotificationAttemptRecorder> attemptRecorder) {
        this.attemptRecorder = attemptRecorder;
    }

    @Override
    public void send(NotificationEvent event) {
        log.info("notification_sent eventId={} type={} recipient={}", event.eventId(), event.type(), event.recipient());
        attemptRecorder.ifAvailable(recorder -> recorder.sent(event));
    }
}
