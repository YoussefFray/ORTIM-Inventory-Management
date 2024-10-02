package com.Inventory.Inventory_Management.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/inventory-transactions")
public class InventoryTransactionController {

    @Autowired
    private InventoryTransactionService inventoryTransactionService;

    @GetMapping
    public List<InventoryTransaction> getAllTransactions() {
        return inventoryTransactionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryTransaction> getTransactionById(@PathVariable UUID id) {
        InventoryTransaction transaction = inventoryTransactionService.findById(id);
        return transaction != null ? ResponseEntity.ok(transaction) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public InventoryTransaction createTransaction(@RequestBody InventoryTransaction transaction) {
        return inventoryTransactionService.save(transaction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryTransaction> updateTransaction(@PathVariable UUID id, @RequestBody InventoryTransaction transaction) {
        transaction.setId(id);
        return ResponseEntity.ok(inventoryTransactionService.save(transaction));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable UUID id) {
        inventoryTransactionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

