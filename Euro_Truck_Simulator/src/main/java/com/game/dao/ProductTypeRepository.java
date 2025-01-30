package com.game.dao;

import com.game.model.ProductType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Transactional
public interface ProductTypeRepository extends JpaRepository<ProductType, Integer>
{
    boolean existsByName(String name);
}
