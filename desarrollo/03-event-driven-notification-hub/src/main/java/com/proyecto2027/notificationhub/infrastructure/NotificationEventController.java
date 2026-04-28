package com.proyecto2027.notificationhub.infrastructure;

import com.proyecto2027.notificationhub.application.ProcessNotificationEventUseCase;
import com.proyecto2027.notificationhub.domain.NotificationEvent;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events/notifications")
public class NotificationEventController {

    private final ProcessNotificationEventUseCase useCase;

    public NotificationEventController(ProcessNotificationEventUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public ProcessNotificationEventUseCase.ProcessingResult consume(@RequestBody NotificationEvent event) {
        return useCase.execute(event);
    }
}
