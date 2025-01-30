package com.game.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "Trucks")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Truck
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_crashed")
    private Boolean isCrashed = false;

    @Column(name = "is_in_trip")
    private Boolean isInTrip = false;

    @Column(name = "bought")
    private Boolean bought = false;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "request_id")
    private Request request = null;

    @Column(name = "max_weight")
    private Double maxWeight;

    public Truck(String name, Request request, Double maxWeight)
    {
        this.name = name;
        this.request = request;
        this.maxWeight = maxWeight;
    }

    public Truck(String name, Double maxWeight)
    {
        this.name = name;
        this.maxWeight = maxWeight;
    }

    public String GetInfo(){
        return name + ", " + maxWeight + " tons";
    }
}
