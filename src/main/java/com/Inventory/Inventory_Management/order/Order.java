package com.Inventory.Inventory_Management.order;


import com.Inventory.Inventory_Management.product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    public enum OrderStatus {
        PENDING, FULFILLED, CANCELLED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product; // Reference to Product entity

    @Column(nullable = false)
    private int quantity; // Number of units ordered

    @Column(nullable = false)
    private LocalDateTime orderDate; // Date when the order was placed

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status; // Status of the order
}

