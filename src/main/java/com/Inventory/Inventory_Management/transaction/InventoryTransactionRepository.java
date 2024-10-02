package com.Inventory.Inventory_Management.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface InventoryTransactionRepository extends JpaRepository<InventoryTransaction, UUID> {
}

