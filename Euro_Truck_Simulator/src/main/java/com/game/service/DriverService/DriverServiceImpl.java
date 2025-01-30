package com.game.service.DriverService;

import com.game.dao.DriverRepository;
import com.game.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class DriverServiceImpl implements DriverService
{
    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private DriverRandomizer driverRandomizer;

    @Override
    public void save(Driver driver) { driverRepository.save(driver); }

    @Override
    public int[] saveDriversList(List<Driver> drivers) {
        driverRepository.saveAll(drivers);
        return new int[0];
    }

    @Override
    public void update(Driver driver) { driverRepository.save(driver); }

    @Override
    public void delete(Driver driver) { driverRepository.delete(driver); }

    @Override
    public void deleteAll() { driverRepository.deleteAll(); }

    @Override
    public List<Driver> findAll() { return driverRepository.findAll(); }

    @Override
    public List<Driver> findByIsHiredTrue() {
        return driverRepository.findByIsHiredTrue();
    }

    @Override
    public List<Driver> findByIsHiredFalse() {
        return driverRepository.findByIsHiredFalse();
    }

    @Override
    public List<Driver> findDriverByIsInTripFalseAndIsHiredTrue() {
        return driverRepository.findDriverByIsInTripFalseAndIsHiredTrue();
    }

    public void initializeDrivers() throws IOException {
        List<Driver> driversInDb = driverRepository.findAll();
        if (driversInDb.isEmpty()) {
            for (int i = 0; i < 5; i++) {
                Driver newDriver = driverRandomizer.generateRandomDriver();
                driverRepository.save(newDriver);
            }
        }
    }
}
