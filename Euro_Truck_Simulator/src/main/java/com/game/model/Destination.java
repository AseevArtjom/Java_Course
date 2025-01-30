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
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "distance")
    private Float distance;

    public Destination(String name,Float distance){
        this.name = name;
        this.distance = distance;
    }
}
