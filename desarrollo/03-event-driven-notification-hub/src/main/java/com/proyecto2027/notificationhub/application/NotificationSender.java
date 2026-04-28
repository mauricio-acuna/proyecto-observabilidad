package com.proyecto2027.notificationhub.application;

import com.proyecto2027.notificationhub.domain.NotificationEvent;

public interface NotificationSender {
    void send(NotificationEvent event);
}
