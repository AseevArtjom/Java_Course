package model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "Tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Cost")
    private BigDecimal cost;

    @Column(name = "Status")
    private Status status;

    @Column(name = "Number")
    private Integer number;

    @ManyToOne
    @JoinColumn(name = "CustomerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "EventId")
    private Event event;
}

