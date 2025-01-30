package com.game.service.DriverService;

import com.game.model.Driver;

import java.io.IOException;
import java.util.List;

public interface DriverService
{
    void save(Driver driver) ;

    int[] saveDriversList(List<Driver> drivers) ;

    void update(Driver driver) ;

    void delete(Driver driver) ;

    List<Driver> findAll() ;

    void deleteAll() ;

    List<Driver> findByIsHiredTrue();

    List<Driver> findByIsHiredFalse();

    List<Driver> findDriverByIsInTripFalseAndIsHiredTrue();

    void initializeDrivers() throws IOException;
}
