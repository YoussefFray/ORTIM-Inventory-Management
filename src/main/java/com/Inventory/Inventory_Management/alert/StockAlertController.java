package com.Inventory.Inventory_Management.alert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/stock-alerts")
public class StockAlertController {

    @Autowired
    private StockAlertService stockAlertService;

    @GetMapping
    public List<StockAlert> getAllAlerts() {
        return stockAlertService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockAlert> getAlertById(@PathVariable UUID id) {
        StockAlert alert = stockAlertService.findById(id);
        return alert != null ? ResponseEntity.ok(alert) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public StockAlert createAlert(@RequestBody StockAlert alert) {
        return stockAlertService.save(alert);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockAlert> updateAlert(@PathVariable UUID id, @RequestBody StockAlert alert) {
        alert.setId(id);
        return ResponseEntity.ok(stockAlertService.save(alert));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlert(@PathVariable UUID id) {
        stockAlertService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

