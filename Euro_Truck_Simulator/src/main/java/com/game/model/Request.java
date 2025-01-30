package com.game.model;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
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
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "required_experience")
    private int required_experience;

    @Column(name = "profit")
    private Double profit;

    @Column(name = "progress")
    private Boolean progress = false;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "driver_id")
    private Driver driver = null;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "truck_id")
    private Truck truck = null;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "destination_id")
    private Destination destination;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_type_id")
    private ProductType productType;

    @Column(name = "delivery_days")
    private int deliveryDays;

    @Column(name = "remaining_days")
    private int remainingDays;

    public void setDeliveryDays(int deliveryDays) {
        this.deliveryDays = deliveryDays;
        this.remainingDays = deliveryDays;
    }

    public void decrementRemainingDays() {
        if (remainingDays > 0) {
            remainingDays--;
        }
    }

    public String GetInfo(){
        return destination.getName() + "[" + destination.getDistance() + " km], " + deliveryDays + " days, " + profit + "$, " + weight + " tons, " + productType.getName() + ", " + required_experience + " experience years";
    }

    public Request(Double weight,int deliveryDays,Double profit ,int required_Experience, Destination destination, ProductType productType){
        this.weight = weight;
        this.deliveryDays = deliveryDays;
        this.profit = profit;
        this.required_experience = required_Experience;
        this.destination = destination;
        this.productType = productType;
    }
}
