package com.Inventory.Inventory_Management.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class InventoryTransactionService {

    @Autowired
    private InventoryTransactionRepository inventoryTransactionRepository;

    public List<InventoryTransaction> findAll() {
        return inventoryTransactionRepository.findAll();
    }

    public InventoryTransaction findById(UUID id) {
        return inventoryTransactionRepository.findById(id).orElse(null);
    }

    public InventoryTransaction save(InventoryTransaction transaction) {
        return inventoryTransactionRepository.save(transaction);
    }

    public void delete(UUID id) {
        inventoryTransactionRepository.deleteById(id);
    }
}

