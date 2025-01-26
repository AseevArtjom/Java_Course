package com.game.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Destinations")
@Data
@Builder
public class Destination {
    @Id
    @Column(name = "Id")
    @GeneratedValue
    private Integer Id;

    @Column(name = "Name")
    private String Name;

    @Column(name = "Distance")
    private Float Distance;

    public Destination(Float distance){
        this.Distance = distance;
    }
}

/*
    Id SERIAL PRIMARY KEY,
    FirstName VARCHAR(60),
    LastName VARCHAR(60),
    Distance FLOAT
*/
