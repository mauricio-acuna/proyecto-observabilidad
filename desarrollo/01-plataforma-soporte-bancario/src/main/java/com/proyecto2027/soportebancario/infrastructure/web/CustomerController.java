package com.proyecto2027.soportebancario.infrastructure.web;

import com.proyecto2027.soportebancario.application.RegisterCustomerUseCase;
import com.proyecto2027.soportebancario.domain.Customer;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final RegisterCustomerUseCase registerCustomerUseCase;

    public CustomerController(RegisterCustomerUseCase registerCustomerUseCase) {
        this.registerCustomerUseCase = registerCustomerUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer register(@Valid @RequestBody RegisterCustomerRequest request) {
        return registerCustomerUseCase.execute(request.documentNumber(), request.fullName(), request.email());
    }

    public record RegisterCustomerRequest(
            @NotBlank String documentNumber,
            @NotBlank String fullName,
            @Email @NotBlank String email
    ) {
    }
}
