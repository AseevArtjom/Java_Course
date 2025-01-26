package com.shop.Ticket_Shop.dao;

import com.shop.Ticket_Shop.model.Role;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer>
{
    Role findByRole_name(String role_name);
}
