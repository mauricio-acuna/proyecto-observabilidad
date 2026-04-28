package com.proyecto2027.notificationhub.infrastructure;

import com.proyecto2027.notificationhub.infrastructure.persistence.NotificationOperationsQuery;
import com.proyecto2027.notificationhub.infrastructure.persistence.NotificationOperationsQuery.NotificationOperationsSnapshot;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notifications/operations")
public class NotificationOperationsController {

    private final NotificationOperationsQuery query;

    public NotificationOperationsController(NotificationOperationsQuery query) {
        this.query = query;
    }

    @GetMapping("/snapshot")
    public NotificationOperationsSnapshot snapshot() {
        return query.snapshot();
    }
}
