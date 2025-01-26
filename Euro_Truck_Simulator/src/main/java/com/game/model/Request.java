package com.game.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Requests")
@Builder
public class Request
{
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @Column(name = "Weight")
    private Double Weight;

    @Column(name = "Required_Experience")
    private int Required_Experience;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Destination_Id")
    private Destination Destination;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ProductType_Id")
    private ProductType ProductType;

    public Request(Double weight, int required_Experience, Destination destination, ProductType productType){
        this.Weight = weight;
        this.Required_Experience = required_Experience;
        this.Destination = destination;
        this.ProductType = productType;
    }
}
/*
    Id SERIAL PRIMARY KEY,
    Weight DECIMAL,
    Required_Experience INT,
    Destination_Id INT,
    ProductType_Id INT,
    FOREIGN KEY (ProductType_Id) REFERENCES ProductTypes(Id) ON DELETE CASCADE ,
    FOREIGN KEY (Destination_Id) REFERENCES Destinations(Id) ON DELETE CASCADE
*/