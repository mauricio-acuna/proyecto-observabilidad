package com.proyecto2027.template.infrastructure;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ReadinessController {

    @GetMapping("/internal/readiness")
    public Map<String, String> readiness() {
        return Map.of(
                "status", "ready",
                "template", "spring-boot-service",
                "observability", "enabled"
        );
    }
}
