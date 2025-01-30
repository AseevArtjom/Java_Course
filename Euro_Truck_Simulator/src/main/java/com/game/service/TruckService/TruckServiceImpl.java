package com.game.service.TruckService;

import com.game.dao.TruckRepository;
import com.game.model.Request;
import com.game.model.Truck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class TruckServiceImpl implements TruckService
{
    @Autowired
    private TruckRepository truckRepository;

    @Autowired
    private TruckRandomizer truckRandomizer;

    @Override
    public void save(Truck truck) { truckRepository.save(truck); }

    @Override
    public int[] saveRequestsList(List<Truck> trucks) {
        truckRepository.saveAll(trucks);
        return new int[0];
    }

    @Override
    public void update(Truck truck) { truckRepository.save(truck); }

    @Override
    public void delete(Truck truck) { truckRepository.delete(truck); }

    @Override
    public void deleteAll() { truckRepository.deleteAll(); }

    @Override
    public List<Truck> findAll() { return truckRepository.findAll(); }

    @Override
    public List<Truck> findByBoughtFalse(){ return truckRepository.findByBoughtFalse(); }

    @Override
    public List<Truck> findByBoughtTrue() { return truckRepository.findByBoughtTrue(); }

    @Override
    public List<Truck> findByIsInTripTrueAndBoughtTrue(){ return truckRepository.findByIsInTripTrueAndBoughtTrue(); }

    @Override
    public List<Truck> findByIsInTripFalseAndBoughtTrue(){ return truckRepository.findByIsInTripFalseAndBoughtTrue(); }

    @Override
    public void initializeTrucks() throws IOException {
        List<Truck> trucksInDb = truckRepository.findAll();
        if(trucksInDb.isEmpty()){
            for (int i = 0; i < 10; i++) {
                Truck newTruck = truckRandomizer.generateRandomTruck();
                truckRepository.save(newTruck);
            }
        }
    }
}
