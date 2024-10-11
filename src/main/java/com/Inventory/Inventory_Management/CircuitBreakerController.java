package com.Inventory.Inventory_Management;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerController {
    @GetMapping("/test-circuit-breaker")
    public String testCircuitBreaker() {
        return "Circuit Breaker is working";
    }
}
