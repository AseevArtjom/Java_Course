package com.game.service.DestinationService;

import com.game.model.Destination;
import com.game.model.Driver;

import java.io.IOException;
import java.util.List;

public interface DestinationService
{
    void save(Destination destination) ;

    int[] saveDestinationsList(List<Destination> destinations) ;

    void update(Destination destination) ;

    void delete(Destination destination) ;

    List<Destination> findAll() ;

    void deleteAll() ;

    boolean existsByName(String name);

    void initializeDestinations() throws IOException;
}
