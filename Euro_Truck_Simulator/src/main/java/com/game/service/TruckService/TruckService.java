package com.game.service.TruckService;

import com.game.model.Request;
import com.game.model.Truck;

import java.io.IOException;
import java.util.List;

public interface TruckService
{
    void save(Truck truck) ;

    int[] saveRequestsList(List<Truck> trucks) ;

    void update(Truck truck) ;

    void delete(Truck truck) ;

    List<Truck> findAll() ;

    void deleteAll() ;

    List<Truck> findByBoughtFalse();

    List<Truck> findByBoughtTrue();

    List<Truck> findByIsInTripTrueAndBoughtTrue();

    List<Truck> findByIsInTripFalseAndBoughtTrue();

    void initializeTrucks() throws IOException;
}
