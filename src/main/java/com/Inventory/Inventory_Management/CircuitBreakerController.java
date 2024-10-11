package com.Inventory.Inventory_Management;

import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class CircuitBreakerController {
    private Logger logger = Logger.getLogger(String.valueOf(CircuitBreakerController.class));
    @GetMapping("/circuit-breaker")
    @Retry(name = "circuitBreaker", fallbackMethod = "hardCodedResponse")
    public String testCircuitBreaker() {
        logger.info("Testing Circuit Breaker");
        return "Circuit Breaker is working";
    }
public String hardCodedResponse(Exception e) {
        return "Circuit Breaker is Open";
    }
}


