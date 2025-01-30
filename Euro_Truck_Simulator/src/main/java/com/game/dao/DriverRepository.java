package com.game.dao;

import com.game.model.Driver;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public interface DriverRepository extends JpaRepository<Driver,Integer>
{
    List<Driver> findByIsHiredTrue();
    List<Driver> findByIsHiredFalse();
    List<Driver> findDriverByIsInTripFalseAndIsHiredTrue();
}
