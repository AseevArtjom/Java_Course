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
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @Column(name = "Name")
    private String Name;

    @Column(name = "Cash")
    private BigDecimal Cash;

    @Column(name = "IsInTrip")
    private Boolean IsInTrip = false;

    @Column(name = "Experience")
    private Float Experience;

    @Column(name = "IsHired")
    private Boolean isHired = false;

    public Driver(String name, BigDecimal cash, Float experience) {
        this.Name = name;
        this.Cash = cash;
        this.Experience = experience;
    }

    public String GetInfo(){
        return Name + " [" + Cash + "$," + Experience + " years" + "]";
    }
}

/*
    Id         SERIAL PRIMARY KEY,
    Name       VARCHAR(60),
    Cash       money,
    IsInTrip   BOOLEAN,
    Experience FLOAT
 */