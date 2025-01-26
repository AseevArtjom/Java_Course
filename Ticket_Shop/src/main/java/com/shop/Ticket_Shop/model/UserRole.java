package com.shop.Ticket_Shop.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "UserRole")
public class UserRole
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_user_user_id",nullable = false)
    private AppUser user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_role_id",nullable = false)
    private Role role;
}
