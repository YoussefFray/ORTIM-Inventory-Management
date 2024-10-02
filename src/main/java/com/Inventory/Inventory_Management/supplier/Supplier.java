package com.Inventory.Inventory_Management.supplier;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "suppliers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(columnDefinition = "JSON")
    private String contactInfo; // Contact details (phone, email, address)

    @Column(nullable = false)
    private LocalDateTime createdAt; // When the supplier was added

    @Column(nullable = false)
    private LocalDateTime updatedAt; // Last update to the supplier
}
