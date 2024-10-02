package com.Inventory.Inventory_Management.alert;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface StockAlertRepository extends JpaRepository<StockAlert, UUID> {
}

