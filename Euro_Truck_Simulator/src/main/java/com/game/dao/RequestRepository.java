package com.game.dao;

import com.game.model.Request;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Transactional
public interface RequestRepository extends JpaRepository<Request, Integer>
{

}
