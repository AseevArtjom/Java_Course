package com.game.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "ProductTypes")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductType
{
    @Id
    @Column(name = "Id")
    @GeneratedValue
    private Integer Id;

    @Column(name = "Name")
    private String Name;

    public ProductType(String name){
        this.Name = name;
    }
}
/*
    Id SERIAL PRIMARY KEY,
    Name VARCHAR(80)
*/