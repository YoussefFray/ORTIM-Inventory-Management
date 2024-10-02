package com.Inventory.Inventory_Management.alert;


import com.Inventory.Inventory_Management.product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "stock_alerts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockAlert {

    public enum AlertType {
        LOW_STOCK, OUT_OF_STOCK
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product; // Reference to Product entity

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AlertType alertType; // Type of alert

    @Column(nullable = false)
    private int threshold; // Quantity level that triggers the alert

    @Column(nullable = false)
    private LocalDateTime alertDate; // Date when the alert was triggered
}

