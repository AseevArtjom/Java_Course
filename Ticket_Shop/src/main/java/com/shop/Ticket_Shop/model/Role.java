package com.shop.Ticket_Shop.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "roles")
public class Role
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false)
    private Integer role_id;

    @Column(name = "role_name", unique = true, length = 30, nullable = false)
    private String role_name;
}

