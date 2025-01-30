package com.game.model;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Drivers")
@Builder
@Data
@Getter
@Setter
public class Driver
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "cash")
    private Double cash;

    @Column(name = "is_in_trip")
    private Boolean isInTrip = false;

    @Column(name = "experience")
    private Float experience;

    @Column(name = "is_hired")
    private Boolean isHired = false;

    public Driver(String name, Double cash, Float experience) {
        this.name = name;
        this.cash = cash;
        this.experience = experience;
        this.isInTrip = false;
        this.isHired = false;
    }

    public String GetInfo(){
        return name + " [" + cash + "$," + experience + " years" + "]";
    }

    public void addProfit(Double cash) {
        this.cash = cash;
    }
}
