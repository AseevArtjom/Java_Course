package com.game.dao;


import com.game.model.Truck;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Transactional
public interface TruckRepository extends JpaRepository<Truck, Integer>
{

}
