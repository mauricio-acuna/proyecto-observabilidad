package com.proyecto2027.modulith.customers;

import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class InMemoryCustomerModule implements CustomerModuleApi {

    private final Set<UUID> customers = ConcurrentHashMap.newKeySet();

    public InMemoryCustomerModule() {
        customers.add(UUID.fromString("00000000-0000-0000-0000-000000000001"));
    }

    @Override
    public boolean customerExists(UUID customerId) {
        return customers.contains(customerId);
    }
}
