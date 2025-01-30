package com.game.dao;

import com.game.model.Destination;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Transactional
public interface DestinationRepository extends JpaRepository<Destination, Integer>
{
    boolean existsByName(String name);
}
