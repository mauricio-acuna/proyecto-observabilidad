package com.proyecto2027.finops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class FinOpsCostGuardianApplication {
    public static void main(String[] args) {
        SpringApplication.run(FinOpsCostGuardianApplication.class, args);
    }
}
