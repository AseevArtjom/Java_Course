package com.game.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "Product_Types")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductType {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String name;

    public ProductType(String name)
    {
        this.name = name;
    }
}