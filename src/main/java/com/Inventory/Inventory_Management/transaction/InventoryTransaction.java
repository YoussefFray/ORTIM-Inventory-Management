package com.Inventory.Inventory_Management.transaction;

import com.Inventory.Inventory_Management.product.Product;
import com.Inventory.Inventory_Management.supplier.Supplier;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "inventory_transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryTransaction {

    public enum TransactionType {
        INBOUND, OUTBOUND
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product; // Reference to Product entity

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType type; // INBOUND or OUTBOUND

    @Column(nullable = false)
    private int quantity; // Number of units in the transaction

    @Column(nullable = false)
    private LocalDateTime date; // Date of the transaction

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = true)
    private Supplier supplier; // Reference to Supplier entity (for INBOUND type)
}

