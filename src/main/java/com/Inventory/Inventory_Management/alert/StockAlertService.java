package com.Inventory.Inventory_Management.alert;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class StockAlertService {

    @Autowired
    private StockAlertRepository stockAlertRepository;

    public List<StockAlert> findAll() {
        return stockAlertRepository.findAll();
    }

    public StockAlert findById(UUID id) {
        return stockAlertRepository.findById(id).orElse(null);
    }

    public StockAlert save(StockAlert alert) {
        return stockAlertRepository.save(alert);
    }

    public void delete(UUID id) {
        stockAlertRepository.deleteById(id);
    }
}

