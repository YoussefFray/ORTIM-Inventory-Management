package com.Inventory.Inventory_Management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@RestController
@RequestMapping("/test")
public class LoadBalancingTestController {

    private Logger logger = Logger.getLogger(String.valueOf(LoadBalancingTestController.class));

    @Autowired
    private RestTemplate restTemplate;

    @Value("${server.port}")
    private String port;

    @GetMapping("/load-balance")
    public String testLoadBalancing() {
        String serviceUrl = "http://Inventory-Management/api/v1/products";
        logger.info("Sending request from port: " + port);
        return restTemplate.getForObject(serviceUrl, String.class);
    }
}