package com.proyecto2027.modulith.customers;

import java.util.UUID;

public interface CustomerModuleApi {
    boolean customerExists(UUID customerId);
}
