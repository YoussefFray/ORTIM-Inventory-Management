package com.Inventory.Inventory_Management;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    @LoadBalanced // This enables Ribbon load balancing
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
