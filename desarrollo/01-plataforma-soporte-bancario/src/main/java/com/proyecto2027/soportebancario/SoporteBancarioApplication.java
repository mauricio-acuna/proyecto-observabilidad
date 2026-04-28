package com.proyecto2027.soportebancario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SoporteBancarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoporteBancarioApplication.class, args);
    }
}
