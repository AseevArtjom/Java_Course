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
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @Column(name = "Name")
    private String Name;

    @Column(name = "IsCrashed")
    private Boolean IsCrashed;

    @Column(name = "IsInTrip")
    private Boolean IsInTrip;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RequestId")
    private Request Request;

    @Column(name = "MaxWeight")
    private int MaxWeight;

    public Truck(String name, Boolean isCrashed, Request request, int maxWeight)
    {
        this.Name = name;
        this.IsCrashed = isCrashed;
        this.Request = request;
        this.MaxWeight = maxWeight;
    }

}
/*
    Id           SERIAL PRIMARY KEY,
    Name         VARCHAR(60),
    IsCrashed    BOOLEAN,
    IsInTrip     BOOLEAN,
    RequestId    INT,
    MaxWeight INT
*/